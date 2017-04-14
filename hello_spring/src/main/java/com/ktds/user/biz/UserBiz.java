package com.ktds.user.biz;

import com.ktds.user.vo.UserVO;

public interface UserBiz {

	public UserVO selectOneUser(UserVO userVO);
	
	public boolean insertUser (UserVO userVO);
	
}
