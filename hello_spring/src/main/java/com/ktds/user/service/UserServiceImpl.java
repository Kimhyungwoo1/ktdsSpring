package com.ktds.user.service;

import com.ktds.common.utilities.SHA256Util;
import com.ktds.user.biz.UserBiz;
import com.ktds.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	@Override
	public UserVO selectOneUser(UserVO userVO) {
		
		String salt = userBiz.getSaltByInfo(userVO.getUserId());
		
		String password = userVO.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		userVO.setUserPassword(password);
		
		return userBiz.selectOneUser(userVO);
	}

	@Override
	public boolean insertUser(UserVO userVO) {
		
		String salt = SHA256Util.generateSalt();
		userVO.setSalt(salt);
		
		String password = userVO.getUserPassword();
		password = SHA256Util.getEncrypt(password, salt);
		userVO.setUserPassword(password);
		
		return userBiz.insertUser(userVO);
	}

}
