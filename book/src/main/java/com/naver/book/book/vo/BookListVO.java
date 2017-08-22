package com.naver.book.book.vo;

import java.util.List;

import com.naver.book.common.web.Pager;
import com.naver.book.common.web.PagerFactory;

public class BookListVO {

	private List<BookVO> bookList;
	private Pager pager;

	public List<BookVO> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookVO> bookList) {
		this.bookList = bookList;
	}

	public Pager getPager() {
		if ( pager == null ) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
