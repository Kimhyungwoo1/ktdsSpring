package com.ktds.board.biz;

import java.util.List;

import com.ktds.board.vo.BoardVO;

public interface BoardBiz {

	public List<BoardVO> getAllArticle();
	
	public BoardVO selectOneArticle(int boardId);
	
	public boolean insertArticle(BoardVO boardVO);
	
	public boolean deleteArticle(int boardId);
}
