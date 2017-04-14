package com.ktds.user.service;

import com.ktds.user.vo.UserVO;

public interface UserService {

	public UserVO selectOneUser(UserVO userVO);

	public boolean insertUser(UserVO userVO);
}
