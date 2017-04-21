package com.ktds.khw.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.khw.board.vo.BoardSearchVO;
import com.ktds.khw.board.vo.BoardVO;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {
	
	@Override
	public int getAllArticlesCount(BoardSearchVO boardSearchVO) {
		return getSqlSession().selectOne("BoardDao.getAllArticlesCount", boardSearchVO);
	}
	
	@Override
	public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
		return getSqlSession().selectList("BoardDao.getAllArticles", boardSearchVO);
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
		return getSqlSession().selectOne("BoardDao.getOneArticle", boardId);
	}

	@Override
	public int insertArticle(BoardVO boardVO) {
		return getSqlSession().insert("BoardDao.insertArticle", boardVO);
	}

	@Override
	public int deleteArticle(int boardId) {
		return getSqlSession().delete("BoardDao.deleteArticle", boardId);
	}

	@Override
	public int updateArticle(BoardVO boardVO) {
		return getSqlSession().update("BoardDao.updateArticle", boardVO);
	}
}
