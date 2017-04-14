package com.ktds.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ktds.board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<BoardVO> getAllArticles() {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT		BOARD_ID ");
			query.append(" 				, SUBJECT ");
			query.append(" 				, CONT ");
			query.append(" 				, WRTR ");
			query.append(" 				, WRT_DATE ");
			query.append(" 				, LIKE_CNT ");
			query.append(" 				, IP ");
			query.append(" FROM 			BOARD ");
			query.append(" ORDER			BY BOARD_ID DESC ");
			
			stmt = conn.prepareStatement(query.toString());
			
			rs = stmt.executeQuery();
			
			List<BoardVO> boardList = new ArrayList<BoardVO>();
			BoardVO boardVO = null;
			
			while(rs.next()){
				boardVO = new BoardVO();
				boardVO.setBoardId(rs.getInt("BOARD_ID"));
				boardVO.setSubject(rs.getString("SUBJECT"));
				boardVO.setContent(rs.getString("CONT"));
				boardVO.setWriter(rs.getString("WRTR"));
				boardVO.setWriteDate(rs.getString("WRT_DATE"));
				boardVO.setLikeCount(rs.getInt("LIKE_CNT"));
				boardVO.setIp(rs.getString("IP"));
				
				boardList.add(boardVO);
			}
			return boardList;
			
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
	public BoardVO getOneArticle(int boardId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT   BOARD_ID ");
			query.append("          , SUBJECT ");
			query.append("          , WRTR ");
			query.append("          , CONT ");
			query.append("          , LIKE_CNT ");
			query.append("          , WRT_DATE ");
			query.append("          , IP ");
			query.append(" FROM     BOARD");
			query.append(" WHERE    BOARD_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, boardId);
			
			rs = stmt.executeQuery();
			
			BoardVO boardVO = null;
			
			if ( rs.next() ){
				boardVO = new BoardVO();
				boardVO.setBoardId(rs.getInt("BOARD_ID"));
				boardVO.setSubject(rs.getString("SUBJECT"));
				boardVO.setWriter(rs.getString("WRTR"));
				boardVO.setContent(rs.getString("CONT"));
				boardVO.setLikeCount(rs.getInt("LIKE_CNT"));
				boardVO.setWriteDate(rs.getString("WRT_DATE"));
				boardVO.setIp(rs.getString("IP"));
			}
			return boardVO;
			
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
	public int insertArticle(BoardVO boardVO) {
		
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();
			
			StringBuffer query = new StringBuffer();
			query.append(" INSERT   INTO BOARD ( ");
			query.append("                          BOARD_ID ");
			query.append("                          , SUBJECT ");
			query.append("                          , CONT ");
			query.append("                          , WRTR ");
			query.append("                          , LIKE_CNT ");
			query.append("                          , WRT_DATE ");
			query.append("                          , IP ");
			query.append("                      ) ");
			query.append(" VALUES               ( ");
			query.append("                          BOARD_ID_SEQ.NEXTVAL ");
			query.append("                          , ? ");
			query.append("                          , ? ");
			query.append("                          , ? ");
			query.append("                          , 0 ");
			query.append("                          , SYSDATE ");
			query.append("                          , ? ");
			query.append("                      )");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, boardVO.getSubject());
			stmt.setString(2, boardVO.getContent());
			stmt.setString(3, boardVO.getWriter());
			stmt.setString(4, boardVO.getIp());
			
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

	@Override
	public int deleteArticle(int boardId) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = dataSource.getConnection();

			StringBuffer query = new StringBuffer();
			query.append(" DELETE ");
			query.append(" FROM		BOARD ");
			query.append(" WHERE	BOARD_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, boardId);

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
