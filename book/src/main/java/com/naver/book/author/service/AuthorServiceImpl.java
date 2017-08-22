package com.naver.book.author.service;

import com.naver.book.author.biz.AuthorBiz;
import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

public class AuthorServiceImpl implements AuthorService {

	private AuthorBiz authorBiz;
	
	public void setAuthorBiz(AuthorBiz authorBiz) {
		this.authorBiz = authorBiz;
	}

	@Override
	public boolean addNewAuthor(AuthorVO authorVO) {
		return authorBiz.addNewAuthor(authorVO);
	}

	@Override
	public AuthorListVO getAllAuthor(AuthorSearchVO authorSearchVO) {
		return authorBiz.getAllAuthor(authorSearchVO);
	}

	@Override
	public AuthorVO getSelectOneAuthor(String id) {
		return authorBiz.getSelectOneAuthor(id);
	}
	
}
