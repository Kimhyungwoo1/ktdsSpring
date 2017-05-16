package com.ktds.user.dao;

import com.ktds.user.vo.UserVO;

public interface UserDao {

	public UserVO selectOneUser(UserVO userVO);
	
	public int insertUser(UserVO userVO);
	
	public String getSaltById(String userId);
}
