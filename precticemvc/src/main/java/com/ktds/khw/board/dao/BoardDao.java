package com.ktds.khw.board.dao;

import java.util.List;

import com.ktds.khw.board.vo.BoardVO;

public interface BoardDao {
	
	public List<BoardVO> getAllArticles();
	
	public BoardVO getOneArticle(int boardId);
	
	public int insertArticle(BoardVO boardVO);
	
	public int deleteArticle(int boardId);

	public int updateArticle(BoardVO boardVo);
}
