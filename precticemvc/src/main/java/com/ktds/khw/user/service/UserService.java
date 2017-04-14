package com.ktds.khw.user.service;

import com.ktds.khw.user.vo.UserVO;

public interface UserService {

	public UserVO selectOneUser(UserVO userVO);
	
	public boolean addUser(UserVO userVO);
	
}
