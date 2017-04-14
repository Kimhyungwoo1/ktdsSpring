package com.ktds.khw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KhwController {

	@RequestMapping("/")
	public String viewHelloPage() {
		return "hello";
	}
	
	@RequestMapping("/bye")
	public String viewByePage() {
		return "bye";
	}
	
	@RequestMapping("/dog")
	public String viewDogSoundPage() {
		return "dog";
	}
	
}
