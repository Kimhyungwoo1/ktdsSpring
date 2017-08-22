package com.naver.book.author.service;

import com.naver.book.author.vo.AuthorListVO;
import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

public interface AuthorService {

	public boolean addNewAuthor(AuthorVO authorVO);
	public AuthorListVO getAllAuthor(AuthorSearchVO authorSearchVO);
	public AuthorVO getSelectOneAuthor(String id);
}
