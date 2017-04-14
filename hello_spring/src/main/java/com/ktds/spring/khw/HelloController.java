package com.ktds.spring.khw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String viewHelloPage() {
		return "hello";
	}
	
	@RequestMapping("/bye")
	public String viewbyePage() {
		return "bye";
	}
	
	@RequestMapping("/myinfo")
	public ModelAndView viewMypage() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("myinfo");	//보여줄 페이지 지
		view.addObject("name", "Kim Hyung Woo");		//페이지에 전달할 데이터 셋팅
		view.addObject("job", "Developer");
		view.addObject("lang", "JAVA");
		view.addObject("dept", "연구소");
		return view;
	}
	
}
