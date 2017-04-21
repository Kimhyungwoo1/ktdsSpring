package com.ktds.board.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

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
	
	@Override
	public int getAllArticlesCount() {
		return getSqlSession().delete("BoardDao.getAllArticlesCount");
	}

	
}
