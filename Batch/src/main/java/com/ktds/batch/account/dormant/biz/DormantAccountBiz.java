package com.ktds.batch.account.dormant.biz;

import java.util.stream.Stream;

import com.ktds.batch.account.dormant.vo.UsersVO;

public interface DormantAccountBiz {

	public Stream<UsersVO> getAllDormantAccounts();
	
}
