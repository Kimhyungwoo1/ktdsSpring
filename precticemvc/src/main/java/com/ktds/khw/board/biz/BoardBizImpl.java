package com.ktds.khw.board.biz;

import java.util.List;

import com.ktds.khw.board.dao.BoardDao;
import com.ktds.khw.board.vo.BoardListVO;
import com.ktds.khw.board.vo.BoardSearchVO;
import com.ktds.khw.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public BoardListVO getAllArticles(BoardSearchVO boardSearchVO) {
		
		int totalCount = boardDao.getAllArticlesCount(boardSearchVO);
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.getPager().setPageNumber(boardSearchVO.getPageNo());
		boardListVO.getPager().setTotalArticleCount(totalCount);
		
		boardSearchVO.setEndArticleNumber(boardListVO.getPager().getEndArticleNumber());
		boardSearchVO.setStartArticleNumber(boardListVO.getPager().getStartArticleNumber());
		
		if ( totalCount == 0) {
			return boardListVO;
		}
		boardListVO.setBoardList(boardDao.getAllArticles(boardSearchVO));
		
		return boardListVO;
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
