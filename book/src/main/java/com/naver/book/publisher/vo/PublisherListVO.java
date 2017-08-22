package com.naver.book.publisher.vo;

import java.util.List;

import com.naver.book.common.web.Pager;
import com.naver.book.common.web.PagerFactory;

public class PublisherListVO {

	private List<PublisherVO> publisherList;
	private Pager pager;

	public List<PublisherVO> getPublisherList() {
		return publisherList;
	}

	public void setPublisherList(List<PublisherVO> publisherList) {
		this.publisherList = publisherList;
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
