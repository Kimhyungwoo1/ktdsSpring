package com.ktds.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.user.service.UserService;
import com.ktds.user.vo.UserVO;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/user/signUp", method=RequestMethod.GET)
	public ModelAndView viewUserSignUp() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/user/signUp");
		
		return view;
	}
	
	@RequestMapping(value="/user/signUp", method=RequestMethod.POST)
	public String doUserSignUp(@Valid @ModelAttribute("signUp") UserVO userVO, Errors errors) {
		
		if ( errors.hasErrors() ){
			return "/user/signUp";
		}
		
		boolean isSuccess = userService.insertUser(userVO);
		
		if ( isSuccess ) {
			return "redirect:/board";
		} else {
			return null;
		}
		
	}
	
	@RequestMapping(value="/user/signIn", method=RequestMethod.GET)
	public ModelAndView viewUserSignIn() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/user/signIn");
		
		return view;
	}
	
	@RequestMapping(value="/user/signIn", method=RequestMethod.POST)
	public String doUserSignIn(UserVO userVO, HttpServletRequest request) {
		
		UserVO loginUserVO = userService.selectOneUser(userVO);

		if (loginUserVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("_USER_", loginUserVO);
			return "redirect:/board";
		}
		return null;
	}
	@RequestMapping("/user/signOut")
	public String doUserSignOut(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/board";
	}
	
}
