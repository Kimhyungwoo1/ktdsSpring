package com.ktds.khw.user.web;

import org.springframework.stereotype.Controller;

import com.ktds.khw.user.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
