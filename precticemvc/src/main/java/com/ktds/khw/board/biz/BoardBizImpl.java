package com.ktds.khw.board.biz;

import java.util.List;

import com.ktds.khw.board.dao.BoardDao;
import com.ktds.khw.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> getAllArticles() {
		return boardDao.getAllArticles();
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
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

	@Override
	public boolean updateArticle(BoardVO boardVO) {
		return boardDao.updateArticle(boardVO) > 0;
	}

}
