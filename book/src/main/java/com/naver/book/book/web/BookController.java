package com.naver.book.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.book.book.service.BookService;
import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;
import com.naver.book.common.web.ListPageExplorer;
import com.naver.book.common.web.PageExplorer;


@Controller
public class BookController {

	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/book/write", method=RequestMethod.GET)
	public ModelAndView viewWriteBookPage() {
		
/*		Map<String, Object> listMap =bookService.getAllPublisherAndAuthor();
		PublisherListVO publisherListVO = (PublisherListVO) listMap.get("publisherList");
		AuthorListVO authorListVO = (AuthorListVO) listMap.get("authorList");*/
		
		BookVO bookVO = bookService.getAllPublisherAndAuthorUseBookVO();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("book/write");
		/*view.addObject("publisherListVO", publisherListVO);
		view.addObject("authorListVO", authorListVO);*/
		view.addObject("bookVO", bookVO);
		
		return view;
	}
	
	@RequestMapping(value="/book/write", method=RequestMethod.POST)
	public String doWriteAction(BookVO bookVO) {
		
		boolean isSuccess = bookService.addNewBook(bookVO);
		
		return "redirect:/book/list";
	}
	
	@RequestMapping("/book/list")
	public ModelAndView viewBookListPage(BookSearchVO bookSearchVO){
		BookListVO bookListVO = bookService.getAllBooks(bookSearchVO);
		
		PageExplorer pager = new ListPageExplorer(bookListVO.getPager());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("book/list");
		view.addObject("bookListVO", bookListVO);
		view.addObject("pager", pager);
		
		return view;
	}
}
