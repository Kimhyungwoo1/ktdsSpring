package com.naver.book.bookauth.biz;

import com.naver.book.bookauth.dao.BookAuthDao;
import com.naver.book.bookauth.vo.BookAuthVO;

public class BookAuthBizImpl implements BookAuthBiz {

	private BookAuthDao bookAuthDao;
	
	public void setBookAuthDao(BookAuthDao bookAuthDao) {
		this.bookAuthDao = bookAuthDao;
	}

	@Override
	public boolean addNewBookAuth(BookAuthVO bookAuthVO) {
		return bookAuthDao.insertNewBookAuthor(bookAuthVO) > 0;
	}
	
}
