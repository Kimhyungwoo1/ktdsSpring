package com.naver.book.author.dao;

import java.util.List;

import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

public interface AuthorDao {

	public int insertNewAuthor(AuthorVO authorVO);
	public List<AuthorVO> selectAllAuthor(AuthorSearchVO authorSearchVO);
	public int selectAllAuthorCount(AuthorSearchVO authorSearchVO);
	public AuthorVO selectOneAuthor(String id);
	
}
