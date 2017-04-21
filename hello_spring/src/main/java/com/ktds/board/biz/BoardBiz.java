package com.ktds.board.biz;

import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public interface BoardBiz {

	public BoardListVO getAllArticle(BoardSearchVO boardSearchVO);
	
	public BoardVO selectOneArticle(int boardId);
	
	public boolean insertArticle(BoardVO boardVO);
	
	public boolean deleteArticle(int boardId);
	
}
