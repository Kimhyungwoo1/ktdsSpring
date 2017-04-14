package com.ktds.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Override
	public List<BoardVO> getAllArticles() {
		return getSqlSession().selectList("BoardDao.getAllArticles");
	}
	
	@Override
	public int insertArticle(BoardVO boardVO) {
		return getSqlSession().insert("BoardDao.insertArticle", boardVO);
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
		return getSqlSession().selectOne("BoardDao.getOneArticle", boardId);
	}

	

	@Override
	public int deleteArticle(int boardId) {
		return getSqlSession().delete("BoardDao.deleteArticle", boardId);
	}
}
