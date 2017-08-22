package com.naver.book.book.dao;

import java.util.List;

import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;

public interface BookDao {

	public String generateBookPK();
	
	public int insertNewBook(BookVO bookVO);
	
	public List<BookVO> selectAllBooks(BookSearchVO bookSearchVO);
	
	public int selectAllBooksCount(BookSearchVO bookSearchVO);
}
