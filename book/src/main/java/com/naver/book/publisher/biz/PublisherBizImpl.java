package com.naver.book.publisher.biz;

import java.util.ArrayList;
import java.util.List;

import com.naver.book.common.web.Pager;
import com.naver.book.publisher.dao.PublisherDao;
import com.naver.book.publisher.vo.PublisherListVO;
import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

public class PublisherBizImpl implements PublisherBiz {

private PublisherDao publisherDao;
	
	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	@Override
	public boolean addNewPublisher(PublisherVO publisherVO) {
		return publisherDao.insertNewPublisher(publisherVO) > 0;
	}

	@Override
	public PublisherListVO getAllPublisher(PublisherSearchVO publisherSearchVO) {
		
		PublisherListVO publisherListVO = new PublisherListVO();
		Pager pager = publisherListVO.getPager();
		pager.setPageNumber(publisherSearchVO.getPageNO());
		
		int publisherCount = publisherDao.selectAllPublisherCount(publisherSearchVO);
		pager.setTotalArticleCount(publisherCount);
		
		publisherSearchVO.setStartArticleNumber(pager.getStartArticleNumber());
		publisherSearchVO.setEndArticleNumber(pager.getEndArticleNumber());
		
		if ( publisherCount > 0 ) {
			List<PublisherVO> publisherList = publisherDao.selectAllPublisher(publisherSearchVO);
			publisherListVO.setPublisherList(publisherList);
		}
		else {
			publisherListVO.setPublisherList(new ArrayList<PublisherVO>());
		}
		
		return publisherListVO;
	}
	
}
