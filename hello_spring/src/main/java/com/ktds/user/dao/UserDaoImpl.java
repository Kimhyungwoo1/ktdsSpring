package com.ktds.user.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.user.vo.UserVO;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public UserVO selectOneUser(UserVO userVO) {
		return getSqlSession().selectOne("UserDao.selectOneUser", userVO);
	}

	@Override
	public int insertUser(UserVO userVO) {
		return getSqlSession().insert("UserDao.insertUser", userVO);
	}

	@Override
	public String getSaltById(String userId) {
		return getSqlSession().selectOne("UserDao.getSaltById", userId);
	}
}
