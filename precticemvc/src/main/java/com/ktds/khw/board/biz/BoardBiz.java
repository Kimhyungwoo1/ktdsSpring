package com.ktds.khw.board.biz;

import com.ktds.khw.board.vo.BoardListVO;
import com.ktds.khw.board.vo.BoardSearchVO;
import com.ktds.khw.board.vo.BoardVO;

public interface BoardBiz {

	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO);
	
	public BoardVO getOneArticle(int boardId);
	
	public boolean insertArticle(BoardVO boardVO);
	
	public boolean deleteArticle(int boardId);
	
	public boolean updateArticle(BoardVO boardVO);
}
