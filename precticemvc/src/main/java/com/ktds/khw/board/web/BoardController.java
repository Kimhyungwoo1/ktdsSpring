package com.ktds.khw.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.khw.board.service.BoardService;
import com.ktds.khw.board.vo.BoardListVO;
import com.ktds.khw.board.vo.BoardSearchVO;
import com.ktds.khw.board.vo.BoardVO;
import com.ktds.khw.common.web.ClassicPageExplorer;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board")
	public ModelAndView viewBoardListPage(BoardSearchVO boardSearchVO) {
		ModelAndView view = new ModelAndView();
		
		// /board/list
		view.setViewName("/board/list");
		
		BoardListVO allArticles = boardService.getAllArticles(boardSearchVO);
		view.addObject("allArticles", allArticles.getBoardList());
		
		ClassicPageExplorer pageExplorer = new ClassicPageExplorer(allArticles.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "이전", "다음", "searchForm");
		
		view.addObject("pager", pager);
		
		return view;
	}
	
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewDetailPage(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/board/detail");
		BoardVO board = boardService.getOneArticle(id);
		view.addObject("board", board);
		
		return view;
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public ModelAndView viewWritePage() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/board/write");
		
		return view;
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String doWriteAction(BoardVO boardVO) {
		
		boolean Success = boardService.insertArticle(boardVO);
		
		if ( Success ) {
			return "redirect:/board";
		}else {
			return null;
		}
		
	}
	
	@RequestMapping(value="/board/delete/{id}", method=RequestMethod.GET)
	public String doDeleteAction(@PathVariable int id) {
		
		boolean Success = boardService.deleteArticle(id);
		
		if ( Success ) {
			return "redirect:/board";
		} else {
			return null;
		}
		
	}
	
	@RequestMapping(value="/board/update/{id}", method=RequestMethod.GET)
	public ModelAndView viewUpdatePage(@PathVariable int id){
		ModelAndView view = new ModelAndView();
		
		logger.info("in the updatePage");
		
		view.setViewName("/board/update");
		
		BoardVO board = boardService.getOneArticle(id);
		view.addObject("board", board);
		
		return view;
	}
	
	@RequestMapping(value="/board/update/{id}", method=RequestMethod.POST)
	public String doActionUpdate(@PathVariable int id){
		
		BoardVO boardVO = boardService.getOneArticle(id);
		logger.info("Subject : " + boardVO.getSubject());
		logger.info("Content : " + boardVO.getContent());
		logger.info("Writer : " + boardVO.getWriter());
		
		boolean isSuccess = boardService.updateArticle(boardVO);
		
		if (isSuccess) {
			logger.info("Success Update");
			return "redirect:/board";
		} else {
			logger.info("Fail Update");
			return null;
		}
		
		
	}
	
}
