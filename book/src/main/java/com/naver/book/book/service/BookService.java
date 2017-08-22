package com.naver.book.book.service;

import java.util.Map;

import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;

public interface BookService {
	
	public boolean addNewBook(BookVO bookVO);
	
	public Map<String, Object> getAllPublisherAndAuthor();
	
	public BookVO getAllPublisherAndAuthorUseBookVO();
	
	public BookListVO getAllBooks(BookSearchVO bookSearchVO);
	
}
