package com.ktds.khw.board.service;

import com.ktds.khw.board.biz.BoardBiz;
import com.ktds.khw.board.vo.BoardListVO;
import com.ktds.khw.board.vo.BoardSearchVO;
import com.ktds.khw.board.vo.BoardVO;

public class BoardServiceImpl implements  BoardService{

	private BoardBiz boardBiz;
	
	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}
	
	@Override
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
		return boardBiz.getAllArticles(boardSearchVO);
	}

	@Override
	public BoardVO getOneArticle(int boardId) {
		return boardBiz.getOneArticle(boardId);
	}

	@Override
	public boolean insertArticle(BoardVO boardVO) {
		return boardBiz.insertArticle(boardVO);
	}

	@Override
	public boolean deleteArticle(int boardId) {
		return boardBiz.deleteArticle(boardId);
	}

	@Override
	public boolean updateArticle(BoardVO boardVO) {
		return boardBiz.updateArticle(boardVO);
	}

}
