package com.naver.book.publisher.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.book.publisher.vo.PublisherSearchVO;
import com.naver.book.publisher.vo.PublisherVO;

public class PublisherDaoImpl extends SqlSessionDaoSupport implements PublisherDao {

	@Override
	public int insertNewPublisher(PublisherVO publisherVO) {
		return getSqlSession().insert("PublisherDao.insertNewPublisher", publisherVO);
	}

	@Override
	public List<PublisherVO> selectAllPublisher(PublisherSearchVO publisherSearchVO) {
		return getSqlSession().selectList("PublisherDao.selectAllPublisher", publisherSearchVO);
	}

	@Override
	public int selectAllPublisherCount(PublisherSearchVO publisherSearchVO) {
		return getSqlSession().selectOne("PublisherDao.selectAllPublisherCount", publisherSearchVO);
	}

}
