package com.ktds.board.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.common.DownloadUtil;
import com.ktds.common.web.ClassicPageExplorer;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/board")
	public ModelAndView viewBoardListPage(BoardSearchVO boardSearchVO, HttpSession session) {
		ModelAndView view = new ModelAndView();
	
		// /board/list
		view.setViewName("/board/list");
		
		BoardListVO allArticles = boardService.getAllArticle(boardSearchVO);
		view.addObject("allArticles", allArticles.getBoardList());
		
		ClassicPageExplorer pagerExplorer = new ClassicPageExplorer(allArticles.getPager());
		String pager = pagerExplorer.getPagingList("pageNo", "[@]", "이전", "다음", "searchForm");
		
		view.addObject("pager", pager);
		
		logger.info("목록에 들어왔습니다.");
		return view;
	}
	
	/*@RequestMapping("/board/json")
	@ResponseBody
	public List<BoardVO> getBoardListJson(BoardSearchVO boardSearchVO) {
		return boardService.getAllArticle(boardSearchVO);
	}*/

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
		
		if( boardVO.getFile() != null && !boardVO.getFile().isEmpty() ){
			
			String fileName = UUID.randomUUID().toString();
			
			String filePath = "/Users/kimhyungwoo/Desktop/uploadFiles/" 
						+ fileName;
			File newFile = new File(filePath);
			// 파일의 원본 명
			boardVO.setDisplayFileName(boardVO.getFile().getOriginalFilename());
			// 암호화된 파일 명
			boardVO.setRealFileName(fileName);
			
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
	
	@RequestMapping("/board/download/{boardId}")
	public void downloadFile(@PathVariable int boardId, HttpServletRequest request, 
							HttpServletResponse response) {
		BoardVO article = boardService.selectOneArticle(boardId);
		
		DownloadUtil downloadUtil = DownloadUtil.getInstance("/Users/kimhyungwoo/Desktop/uploadFiles/");
		try {
			downloadUtil.download(request, response, article.getRealFileName()
								, article.getDisplayFileName());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
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
