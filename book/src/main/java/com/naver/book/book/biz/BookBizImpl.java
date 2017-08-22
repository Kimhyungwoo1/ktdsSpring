package com.naver.book.book.biz;

import java.util.ArrayList;
import java.util.List;

import com.naver.book.book.dao.BookDao;
import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;
import com.naver.book.common.web.Pager;

public class BookBizImpl implements BookBiz {

	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public boolean addNewBook(BookVO bookVO) {
		
		// 아이디를 생성해서 넣어주고 return 한다.
		String bookId = bookDao.generateBookPK();
		bookVO.setBookId(bookId);
		
		return bookDao.insertNewBook(bookVO) > 0;
	}

	@Override
	public BookListVO getAllBooks(BookSearchVO bookSearchVO) {
		
		BookListVO bookListVO = new BookListVO();
		Pager pager = bookListVO.getPager();
		pager.setPageNumber(bookSearchVO.getPageNo());
		
		int bookCount = bookDao.selectAllBooksCount(bookSearchVO);
		pager.setTotalArticleCount(bookCount);
		
		bookSearchVO.setEndArticleNumber(pager.getEndArticleNumber());
		bookSearchVO.setStartArticleNumber(pager.getStartArticleNumber());
		
		if ( bookCount > 0 ) {
			List<BookVO> bookList = bookDao.selectAllBooks(bookSearchVO);
			bookListVO.setBookList(bookList);
		}
		else {
			bookListVO.setBookList(new ArrayList<BookVO>());
		}
		
		return bookListVO;
	}
	
}
