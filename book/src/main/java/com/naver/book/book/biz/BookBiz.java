package com.naver.book.book.biz;

import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;

public interface BookBiz {
	
	public boolean addNewBook(BookVO bookVO);
	
	public BookListVO getAllBooks(BookSearchVO bookSearchVO);
	
}
