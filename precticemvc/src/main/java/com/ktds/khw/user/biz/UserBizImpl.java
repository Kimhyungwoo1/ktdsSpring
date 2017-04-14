package com.ktds.khw.user.biz;

import com.ktds.khw.user.dao.UserDao;
import com.ktds.khw.user.vo.UserVO;

public class UserBizImpl implements UserBiz{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public UserVO selectOneUser(UserVO userVO) {
		return userDao.selectOneUser(userVO);
	}

	@Override
	public boolean addUser(UserVO userVO) {
		return userDao.insertUser(userVO) > 0;
	}

}
