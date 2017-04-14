package com.ktds.khw.board.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.khw.board.service.BoardService;
import com.ktds.khw.board.vo.BoardVO;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board")
	public ModelAndView viewBoardListPage() {
		ModelAndView view = new ModelAndView();
		
		// /board/list
		view.setViewName("/board/list");
		
		List<BoardVO> allArticles = boardService.getAllArticles();
		view.addObject("allArticles", allArticles);
		
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
		
		view.setViewName("/board/update");
		
		BoardVO board = boardService.getOneArticle(id);
		view.addObject("board", board);
		
		return view;
	}
	
	@RequestMapping(value="/board/update/{id}", method=RequestMethod.POST)
	public String doActionUpdate(@PathVariable int id){
		
		BoardVO boardVO = boardService.getOneArticle(id);
		boolean isSuccess = boardService.updateArticle(boardVO);
		
		if (isSuccess) {
			return "redirect:/board";
		} else {
			return null;
		}
		
		
	}
	
}
