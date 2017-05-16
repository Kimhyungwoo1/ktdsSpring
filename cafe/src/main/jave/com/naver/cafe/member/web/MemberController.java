package com.naver.cafe.member.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.cafe.member.service.MemberService;
import com.naver.cafe.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/user/signin", method=RequestMethod.GET)
	public ModelAndView viewsignInPage() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("member/signIn");
		
		return view;
	}
	
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	public void doSignInAction(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) {
		
		
		MemberVO login = memberService.loginMember(memberVO);
		if ( login != null ) {
			try {
				PrintWriter write = response.getWriter();
				write.append("OK");
				write.flush();
				write.close();
				HttpSession session = request.getSession();
				session.setAttribute("_USER_", login);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		else {
			try {
				PrintWriter write = response.getWriter();
				write.append("FAIL");
				write.flush();
				write.close();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
	}
	
	@RequestMapping(value="/user/signup", method=RequestMethod.GET)
	public ModelAndView viewSignUpPage() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("member/signUp");
		
		return view;
	}
	
	@RequestMapping(value="/user/signup", method=RequestMethod.POST)
	public void doSignUpAction(MemberVO memberVO, HttpServletResponse response) {
		
		try {
			
			boolean isValidPassword = verify(memberVO.getMemberPassword());
			if ( isValidPassword ) {
				try {
					memberService.addMember(memberVO);
					PrintWriter writer = response.getWriter();
					writer.append("OK");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
				
			}
			else {
				try {
					PrintWriter writer = response.getWriter();
					writer.append("FAIL");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			
		}
		catch (RuntimeException e){
			throw new RuntimeException("아이디가 중복됩니다. 다른아이디로 가입하세요!");
			
		}
	}
	
	@RequestMapping("/user/signout")
	public String doSignOutAction(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/club/qwds";
	}
	
	//페스워드 정책 정규식 표현	()하나당 조건 하나이다.그리고 맨 마지막.{8,}은 8글자 이상 써야 통과되는 조건이다.
	public boolean verify (String password) {
		String passwordPoilicy = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9가-힣]).{8,})";
		Pattern pattern = Pattern.compile(passwordPoilicy);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
