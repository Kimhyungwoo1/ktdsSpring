package com.ktds.khw.user.biz;

import com.ktds.khw.user.vo.UserVO;

public interface UserBiz {

	public UserVO selectOneUser(UserVO userVO);
	
	public boolean addUser(UserVO userVO);
	
}
