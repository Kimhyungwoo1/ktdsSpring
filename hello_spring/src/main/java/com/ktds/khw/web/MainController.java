package com.ktds.khw.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.khw.service.MainService;

public class MainController {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		
		MainService mainService = ctx.getBean("mainServiceImpl", MainService.class); //내부적으로 캐스팅 해준다.
		mainService.printMessage();
	}
	
}
