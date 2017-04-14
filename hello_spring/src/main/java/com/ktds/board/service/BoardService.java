package com.ktds.board.service;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getAllArticle();
	
	public BoardVO selectOneArticle(int boardId);
	
	public boolean insertArticle(BoardVO boardVO);
	
	public boolean deleteArticle(int boardId);
}
