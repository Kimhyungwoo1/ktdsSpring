package com.naver.book.book.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.book.book.service.BookService;
import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;
import com.naver.book.publisher.vo.PublisherVO;

@Controller
public class BookControllerForAPI {

	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/api/v1/book/list")
	@ResponseBody
	public BookListVO getAllBookList(BookSearchVO bookSearchVO) {
		
		BookListVO bookList = bookService.getAllBooks(bookSearchVO);
		
		return bookList;
	}
	
	@GetMapping("/api/v1/book/write")
	@ResponseBody
	public Map<String, Object> getAuthorAndPublisher(BookVO bookVO) {
		Map<String, Object> pubAndAuth = bookService.getAllPublisherAndAuthor();
		return pubAndAuth;
	}
	
	@PostMapping("/api/v1/book/write")
	@ResponseBody
	public Map<String, Boolean> writeBook(BookVO bookVO) {
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("result", bookService.addNewBook(bookVO));
		
		return result;
		
	}
}
