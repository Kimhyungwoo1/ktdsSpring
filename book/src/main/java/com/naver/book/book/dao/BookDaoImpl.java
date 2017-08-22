package com.naver.book.book.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;

public class BookDaoImpl extends SqlSessionDaoSupport implements BookDao {

	@Override
	public String generateBookPK() {
		return getSqlSession().selectOne("BookDao.generateBookPK");
	}
	
	@Override
	public int insertNewBook(BookVO bookVO) {
		return getSqlSession().insert("BookDao.insertNewBook", bookVO);
	}

	@Override
	public List<BookVO> selectAllBooks(BookSearchVO bookSearchVO) {
		return getSqlSession().selectList("BookDao.selectAllBooks", bookSearchVO);
	}

	@Override
	public int selectAllBooksCount(BookSearchVO bookSearchVO) {
		return getSqlSession().selectOne("BookDao.selectAllBooksCount", bookSearchVO);
	}

	

}
