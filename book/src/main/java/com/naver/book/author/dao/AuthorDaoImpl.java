package com.naver.book.author.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.book.author.vo.AuthorSearchVO;
import com.naver.book.author.vo.AuthorVO;

public class AuthorDaoImpl extends SqlSessionDaoSupport implements AuthorDao {

	@Override
	public int insertNewAuthor(AuthorVO authorVO) {
		return getSqlSession().insert("AuthorDao.insertNewAuthor", authorVO);
	}

	@Override
	public List<AuthorVO> selectAllAuthor(AuthorSearchVO authorSearchVO) {
		return getSqlSession().selectList("AuthorDao.selectAllAuthor", authorSearchVO);
	}

	@Override
	public int selectAllAuthorCount(AuthorSearchVO authorSearchVO) {
		return getSqlSession().selectOne("AuthorDao.selectAllAuthorCount", authorSearchVO);
	}

	@Override
	public AuthorVO selectOneAuthor(String id) {
		return getSqlSession().selectOne("AuthorDao.selectOneAuthor", id);
	}

	
	
}
