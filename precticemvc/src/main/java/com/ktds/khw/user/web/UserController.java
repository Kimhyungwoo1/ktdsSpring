package com.ktds.khw.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.khw.user.service.UserService;
import com.ktds.khw.user.vo.UserVO;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/user/signIn", method=RequestMethod.GET)
	public ModelAndView viewSignInPage() {
		ModelAndView view = new ModelAndView();
		
		logger.info("in the signIn page");
		view.setViewName("/user/signIn");
		
		return view;
	}
	
	@RequestMapping(value="/user/signIn", method=RequestMethod.POST)
	public String doSignIn(UserVO userVO, HttpServletRequest request) {
		
		UserVO loginUser = userService.selectOneUser(userVO);
		logger.info("userId : " + userVO.getUserId());
		logger.info("userPassword : " + userVO.getUserPassword());
		
		if ( loginUser != null ) {
			logger.info("signIn Success");
			HttpSession session = request.getSession();
			session.setAttribute("_USER_", loginUser);
			return "redirect:/board";
		}
		else {
			logger.info("signIn Fail");
			return null;
		}
		
	}
	
	@RequestMapping(value="/user/signUp", method=RequestMethod.GET)
	public ModelAndView viewSignUpPage() {
		
		logger.info("in the SignUp Page");
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/user/signUp");
		
		return view;
	}
	
	@RequestMapping(value="/user/signUp", method=RequestMethod.POST)
	public String doSignUp(UserVO userVO) {
		
		
		
		boolean signUp = userService.addUser(userVO);
		
		if ( signUp ) {
			logger.info("signIn Seccess");
			return "redirect:/board";
		}
		else {
			logger.info("signIn Fail");
			return null;
		}
		
	}
	
	@RequestMapping("/user/signOut")
	public String doSignOut(HttpSession session) {
		
		session.invalidate();
		logger.info("signOut Seccess");
		
		return "redirect:/board";
	}
	
}
