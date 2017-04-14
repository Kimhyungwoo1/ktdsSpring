package com.ktds.khw.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.ktds.khw.user.vo.UserVO;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public UserVO selectOneUser(UserVO userVO) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append(" SELECT		USR_ID ");
			query.append(" 				, USR_NM ");
			query.append(" 				, USR_PWD ");
			query.append(" FROM			USRS ");
			query.append(" WHERE			USR_ID = ? ");
			query.append(" AND			USR_PWD = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserPassword());

			rs = stmt.executeQuery();
			UserVO user = null;
			if (rs.next()) {
				user = new UserVO();
				user.setUserId(rs.getString("USR_ID"));
				user.setUserName(rs.getString("USR_NM"));
				user.setUserPassword(rs.getString("USR_PWD"));
			}
			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public int insertUser(UserVO userVO) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();
			StringBuffer query = new StringBuffer();
			query.append(" INSERT	INTO		USERS	( ");
			query.append(" 							USR_ID ");
			query.append(" 							, USR_NM ");
			query.append(" 							, USR_PWD ");
			query.append(" 							, JOIN_DT ");
			query.append(" 							) ");
			query.append(" VALUES					( ");
			query.append(" 							? ");
			query.append(" 							, ? ");
			query.append(" 							, ? ");
			query.append(" 							, SYSDATE ");
			query.append(" 							) ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserName());
			stmt.setString(3, userVO.getUserPassword());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
	}

}
