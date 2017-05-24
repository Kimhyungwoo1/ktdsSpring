package com.ktds.batch.account.dormant.dao;

import java.util.List;

import com.ktds.batch.account.dormant.vo.UsersVO;

public interface DormantAccountDao {

	public List<UsersVO> selectAllDormantAccounts();
	
}
