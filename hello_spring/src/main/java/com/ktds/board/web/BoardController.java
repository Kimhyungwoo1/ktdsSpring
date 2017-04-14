package com.ktds.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardVO;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/board")
	public ModelAndView viewBoardListPage() {
		ModelAndView view = new ModelAndView();

		// /board/list
		view.setViewName("/board/list");

		List<BoardVO> allArticles = boardService.getAllArticle();
		view.addObject("allArticles", allArticles);

		logger.info("목록에 들어왔습니다.");
		return view;
	}
	
	@RequestMapping("/board/json")
	@ResponseBody
	public List<BoardVO> getBoardListJson() {
		return boardService.getAllArticle();
	}

	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewDetailPage(@PathVariable int id) {
		ModelAndView view = new ModelAndView();

		logger.info("boardId : "+id);
		view.setViewName("/board/detail");
		BoardVO board = boardService.selectOneArticle(id);
		view.addObject("board", board);

		return view;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public ModelAndView viewWritePage() {
		ModelAndView view = new ModelAndView();

		logger.info("writpage에 들어왔습니다.");
		view.setViewName("/board/write");

		return view;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String doWriteAction(@Valid @ModelAttribute("writeForm") BoardVO boardVO, Errors errors) {

		
		logger.info(boardVO.getSubject());
		
		if (errors.hasErrors()) {
			return "/board/write";
		}
		
		logger.info("" + boardVO.getFile());
		
		if( !boardVO.getFile().isEmpty() ){
			String filePath = "/Users/kimhyungwoo/Desktop/uploadFiles/" 
						+ boardVO.getFile().getOriginalFilename();
			File newFile = new File(filePath);
			
			try {
				boardVO.getFile().transferTo(newFile);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		boolean Success = boardService.insertArticle(boardVO);
		
		if (Success) {
			return "redirect:/board";
		} else {
			return null;
		}

	}
	
	@RequestMapping("/board/delete/{id}")
	public String doActionDelete(@PathVariable int id){
		
		boolean isSuccess = boardService.deleteArticle(id);
		
		logger.info(id + "번이 삭제되었습니다.");
		
		if (isSuccess) {
			return "redirect:/board";
		}
		return null;
		
	}

}
