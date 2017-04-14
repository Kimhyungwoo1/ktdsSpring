package com.ktds.board.biz;

import java.util.List;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<BoardVO> getAllArticle() {
		return boardDao.getAllArticles();
	}

	@Override
	public BoardVO selectOneArticle(int boardId) {
		return boardDao.getOneArticle(boardId);
	}

	@Override
	public boolean insertArticle(BoardVO boardVO) {
		return boardDao.insertArticle(boardVO) > 0;
	}

	@Override
	public boolean deleteArticle(int boardId) {
		return boardDao.deleteArticle(boardId) > 0;
	}

	
}
