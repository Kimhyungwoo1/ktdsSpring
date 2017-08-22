package com.naver.book.author.vo;

import java.util.List;

import com.naver.book.common.web.Pager;
import com.naver.book.common.web.PagerFactory;

public class AuthorListVO {

	private Pager pager;
	private List<AuthorVO> authorList;

	public Pager getPager() {
		if ( pager == null) {
			pager = PagerFactory.getPager(Pager.ORACLE);
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<AuthorVO> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<AuthorVO> authorList) {
		this.authorList = authorList;
	}
	
}
