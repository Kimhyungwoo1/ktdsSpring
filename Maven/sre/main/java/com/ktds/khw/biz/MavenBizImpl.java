package com.ktds.khw.biz;

import com.ktds.khw.dao.MavenDao;

public class MavenBizImpl implements MavenBiz{

	private MavenDao mavenDao;
	
	public void setMavenDao(MavenDao mavenDao) {
		this.mavenDao = mavenDao;
	}
	
	@Override
	public void MavenTestBiz() {
		mavenDao.MavenTest();
	}

}
