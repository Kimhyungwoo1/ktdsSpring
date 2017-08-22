package com.naver.book.publisher.biz;

import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

public interface PublisherBiz {

	public boolean addNewPublisher(PublisherVO publisherVO);
	
	public PublisherListVO getAllPublisher(PublisherSearchVO publisherSearchVO);
	
}
