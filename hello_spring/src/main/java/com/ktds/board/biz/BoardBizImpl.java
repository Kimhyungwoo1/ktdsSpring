package com.ktds.board.biz;

import java.util.ArrayList;

import com.ktds.board.dao.BoardDao;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;

public class BoardBizImpl implements BoardBiz{

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public BoardListVO getAllArticle(BoardSearchVO boardSearchVO) {
		
		int totalCount = boardDao.getAllArticlesCount(boardSearchVO);
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.getPager().setPageNumber(boardSearchVO.getPageNo());
		boardListVO.getPager().setTotalArticleCount(totalCount);
		
		boardSearchVO.setEndArticleNumber(boardListVO.getPager().getEndArticleNumber());
		boardSearchVO.setStartArticleNumber(boardListVO.getPager().getStartArticleNumber());
		
		if ( totalCount == 0 ){
			return boardListVO;
		}
		boardListVO.setBoardList(boardDao.getAllArticles(boardSearchVO));
		
		return boardListVO;
		
	}

	@Override
	public BoardVO selectOneArticle(int boardId) {
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
	
	
}
