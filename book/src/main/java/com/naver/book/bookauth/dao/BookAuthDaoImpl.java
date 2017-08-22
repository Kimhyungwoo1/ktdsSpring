package com.naver.book.bookauth.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.book.bookauth.vo.BookAuthVO;

public class BookAuthDaoImpl extends SqlSessionDaoSupport implements BookAuthDao {

	@Override
	public int insertNewBookAuthor(BookAuthVO bookAuthVO) {
		return getSqlSession().insert("BookAuthDao.insertNewBookAuthor", bookAuthVO);
	}

}
