package com.naver.book.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.naver.book.author.biz.AuthorBiz;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;
import com.naver.book.book.biz.BookBiz;
import com.naver.book.book.vo.BookListVO;
import com.naver.book.book.vo.BookSearchVO;
import com.naver.book.book.vo.BookVO;
import com.naver.book.bookauth.biz.BookAuthBiz;
import com.naver.book.bookauth.vo.BookAuthVO;
import com.naver.book.publisher.biz.PublisherBiz;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;

public class BookServiceImpl implements BookService {

	private BookBiz bookBiz;
	private PublisherBiz publisherBiz;
	private AuthorBiz authorBiz;
	private BookAuthBiz bookAuthBiz;
	
	public void setBookBiz(BookBiz bookBiz) {
		this.bookBiz = bookBiz;
	}
	
	public void setPublisherBiz(PublisherBiz publisherBiz) {
		this.publisherBiz = publisherBiz;
	}
	
	public void setAuthorBiz(AuthorBiz authorBiz) {
		this.authorBiz = authorBiz;
	}
	
	public void setBookAuthBiz(BookAuthBiz bookAuthBiz) {
		this.bookAuthBiz = bookAuthBiz;
	}

	@Override
	public Map<String, Object> getAllPublisherAndAuthor() {
		
		PublisherSearchVO publisherSearchVO = new PublisherSearchVO();
		publisherSearchVO.setCheck(false);
		PublisherListVO publisherList = publisherBiz.getAllPublisher(publisherSearchVO);
		
		AuthorSearchVO authorSearchVO = new AuthorSearchVO();
		authorSearchVO.setCheck(false);
		AuthorListVO authorList = authorBiz.getAllAuthor(authorSearchVO);
		
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("publisherList", publisherList);
		listMap.put("authorList", authorList);
		
		return listMap;
	}

	@Override
	public BookVO getAllPublisherAndAuthorUseBookVO() {
		
		PublisherSearchVO publisherSearchVO = new PublisherSearchVO();
		publisherSearchVO.setCheck(false);
		PublisherListVO publisherList = publisherBiz.getAllPublisher(publisherSearchVO);
		
		AuthorSearchVO authorSearchVO = new AuthorSearchVO();
		authorSearchVO.setCheck(false);
		AuthorListVO authorList = authorBiz.getAllAuthor(authorSearchVO);
		
		BookVO bookVO = new BookVO();
		
		bookVO.setPublisherList(publisherList.getPublisherList());
		bookVO.setAuthorList(authorList.getAuthorList());
		
		return bookVO;
	}

	@Override
	public boolean addNewBook(BookVO bookVO) {
		
		boolean isSuccess = bookBiz.addNewBook(bookVO);
		
		if ( isSuccess ) {
			BookAuthVO bookAuthVO = new BookAuthVO();
			bookAuthVO.setBookId(bookVO.getBookId());
			
			List<String> authorIdList = bookVO.getAuthorId();
			
			for (String authorId : authorIdList) {
				bookAuthVO.setAuthorId(authorId);
				bookAuthBiz.addNewBookAuth(bookAuthVO);
			}
			
		}
		
		return isSuccess;
	}

	@Override
	public BookListVO getAllBooks(BookSearchVO bookSearchVO) {
		return bookBiz.getAllBooks(bookSearchVO);
	}
}
