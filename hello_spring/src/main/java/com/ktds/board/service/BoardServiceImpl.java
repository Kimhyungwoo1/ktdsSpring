package com.ktds.board.service;

import java.util.List;

import com.ktds.board.biz.BoardBiz;
import com.ktds.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {

	private BoardBiz boardBiz;

	public void setBoardBiz(BoardBiz boardBiz) {
		this.boardBiz = boardBiz;
	}

	@Override
	public List<BoardVO> getAllArticle() {
		
		return boardBiz.getAllArticle();

	}

	@Override
	public BoardVO selectOneArticle(int boardId) {
		return boardBiz.selectOneArticle(boardId);
	}

	@Override
	public boolean insertArticle(BoardVO boardVO) {
		return boardBiz.insertArticle(boardVO);
	}

	@Override
	public boolean deleteArticle(int boardId) {
		return boardBiz.deleteArticle(boardId);
	}

}
