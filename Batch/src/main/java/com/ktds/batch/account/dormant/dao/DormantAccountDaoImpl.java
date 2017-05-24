package com.ktds.batch.account.dormant.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.batch.account.dormant.vo.UsersVO;

public class DormantAccountDaoImpl extends SqlSessionDaoSupport implements DormantAccountDao {

	@Override
	public List<UsersVO> selectAllDormantAccounts() {
		return getSqlSession().selectList("DormantAccountDao.selectAllDormantAccounts");
	}

}
