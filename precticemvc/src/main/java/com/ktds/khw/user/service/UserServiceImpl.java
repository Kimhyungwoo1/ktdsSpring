package com.ktds.khw.user.service;

import com.ktds.khw.user.biz.UserBiz;
import com.ktds.khw.user.vo.UserVO;

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
	public boolean addUser(UserVO userVO) {
		return userBiz.addUser(userVO);
	}

}
