package com.ktds.khw.board.service;

import java.util.List;

import com.ktds.khw.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getAllArticles();

	public BoardVO getOneArticle(int boardId);

	public boolean insertArticle(BoardVO boardVO);

	public boolean deleteArticle(int boardId);
	
	public boolean updateArticle(BoardVO boardVO);

}
