package com.ktds.user.service;

import com.ktds.user.biz.UserBiz;
import com.ktds.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public UserVO selectOneUser(UserVO userVO) {
		return userBiz.selectOneUser(userVO);
	}

	@Override
	public boolean insertUser(UserVO userVO) {
		return userBiz.insertUser(userVO);
	}

}
