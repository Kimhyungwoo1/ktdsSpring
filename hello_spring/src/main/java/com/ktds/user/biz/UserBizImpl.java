package com.ktds.user.biz;

import com.ktds.user.dao.UserDao;
import com.ktds.user.vo.UserVO;

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
	public boolean insertUser(UserVO userVO) {
		return userDao.insertUser(userVO) > 0;
	}

	@Override
	public String getSaltByInfo(String userId) {
		return userDao.getSaltById(userId);
	}

}
