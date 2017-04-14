package com.ktds.khw.user.dao;

import com.ktds.khw.user.vo.UserVO;

public interface UserDao {

	public UserVO selectOneUser(UserVO userVO);
	
	public int insertUser(UserVO userVO);
	
}
