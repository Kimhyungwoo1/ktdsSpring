package com.ktds.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.user.vo.UserVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public UserVO selectOneUser(UserVO userVO) {
		return getSqlSession().selectOne("UserDao.selectOneUser", userVO);
	}

	@Override
	public int insertUser(UserVO userVO) {
		return getSqlSession().insert("UserDao.insertUser", userVO);
	}
}
