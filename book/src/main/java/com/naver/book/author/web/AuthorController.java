package com.naver.book.author.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.book.author.service.AuthorService;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;
import com.naver.book.common.web.ListPageExplorer;
import com.naver.book.common.web.PageExplorer;

@Controller
public class AuthorController {

	private AuthorService authorService;
	
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping(value="/author/write", method=RequestMethod.GET)
	public String viewAuthorWritePage(){
		return "author/write";
	}
	
	@RequestMapping(value="/author/write", method=RequestMethod.POST)
	public String ActionAuthorWrite(AuthorVO authorVO) {
		
		String intro = authorVO.getAuthorIntro();
		intro = intro.replace("\n", "<br/>");
		intro = intro.replace("\r", "");
		authorVO.setAuthorIntro(intro);
		
		boolean isSuccess = authorService.addNewAuthor(authorVO);
		return "redirect:/author/list";
	}
	
	@RequestMapping("/author/list")
	public ModelAndView viewAuthorListPage(AuthorSearchVO authorSearchVO){
		
		AuthorListVO authorListVO = authorService.getAllAuthor(authorSearchVO);
		PageExplorer pager = new ListPageExplorer(authorListVO.getPager());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("author/list");
		view.addObject("authorListVO", authorListVO);
		view.addObject("pager", pager);
		
		return view;
	}
}
