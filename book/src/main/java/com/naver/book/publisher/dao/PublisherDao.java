package com.naver.book.publisher.dao;

import java.util.List;

import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

public interface PublisherDao {
	
	public int insertNewPublisher(PublisherVO publisherVO);
	
	public List<PublisherVO> selectAllPublisher(PublisherSearchVO publisherSearchVO);
	
	public int selectAllPublisherCount(PublisherSearchVO publisherSearchVO);
	
}
