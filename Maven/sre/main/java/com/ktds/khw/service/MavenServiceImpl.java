package com.ktds.khw.service;

import com.ktds.khw.biz.MavenBiz;

public class MavenServiceImpl implements MavenService{

	private MavenBiz mavenBiz;
	
	public void setMavenBiz(MavenBiz mavenBiz) {
		this.mavenBiz = mavenBiz;
	}
	
	@Override
	public void MavenTestService() {
		mavenBiz.MavenTestBiz();
	}

}
