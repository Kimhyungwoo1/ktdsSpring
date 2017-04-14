package com.ktds.khw.web;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ktds.khw.service.MavenService;

public class ApplicationContext {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/AbstractApplicationContextss.xml");
		
		MavenService mavenService = ctx.getBean("mavenServiceImpl", MavenService.class);
		mavenService.MavenTestService();
		
	}
	
}
