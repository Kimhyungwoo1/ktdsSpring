package com.ktds.khw.board.biz;

import java.util.List;

import com.ktds.khw.board.vo.BoardVO;

public interface BoardBiz {

	public List<BoardVO> getAllArticles();
	
	public BoardVO getOneArticle(int boardId);
	
	public boolean insertArticle(BoardVO boardVO);
	
	public boolean deleteArticle(int boardId);
	
	public boolean updateArticle(BoardVO boardVO);
}
