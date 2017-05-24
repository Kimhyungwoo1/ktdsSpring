package com.ktds.batch.account.dormant.biz;

import java.util.stream.Stream;

import com.ktds.batch.account.dormant.dao.DormantAccountDao;
import com.ktds.batch.account.dormant.vo.UsersVO;

public class DormantAccountBizImpl implements DormantAccountBiz {

	private DormantAccountDao dormantAccountDao;
	
	public void setDormantAccountDao(DormantAccountDao dormantAccountDao) {
		this.dormantAccountDao = dormantAccountDao;
	}

	@Override
	public Stream<UsersVO> getAllDormantAccounts() {
		Stream<UsersVO> allDormantAccounts = this.dormantAccountDao.selectAllDormantAccounts().stream();
		return null;
	}
	
}
