package com.ktds.khw.service;

import com.ktds.khw.biz.MainBiz;

public class MainServiceImpl implements MainService{

	private MainBiz mainBiz;
	
	public void setMainBiz(MainBiz mainBiz) {
		this.mainBiz = mainBiz;
	}
	
	@Override
	public void printMessage() {
		System.out.println("스프링으로 만든 객체입니다...");
		mainBiz.printBizMessage();
	}

	
	
}
