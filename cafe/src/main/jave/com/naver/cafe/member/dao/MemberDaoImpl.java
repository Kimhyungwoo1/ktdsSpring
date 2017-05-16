package com.naver.cafe.member.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.member.vo.MemberVO;

public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	@Override
	public int insertMember(MemberVO memberVO) {
		return getSqlSession().insert(ME + ".insertMember", memberVO);
	}

	@Override
	public MemberVO selectOneMember(MemberVO memberVO) {
		return getSqlSession().selectOne(ME + ".selectOneMember", memberVO);
	}

	@Override
	public String getSalt(String memberId) {
		return getSqlSession().selectOne(ME + ".getSalt", memberId);
	}

	@Override
	public int plusLoginFailCount(String memberId) {
		return getSqlSession().update(ME + ".plusLoginFailCount", memberId);
	}

	@Override
	public int updateLockStatus(String memberId) {
		return getSqlSession().update(ME + ".updateLockStatus", memberId);
	}

	@Override
	public int selectLockStatus(String memberId) {
		return getSqlSession().selectOne(ME + ".selectLockStatus" , memberId);
	}

	@Override
	public int updateClearLoginFailCount(String memberId) {
		return getSqlSession().update(ME + ".updateClearLoginFailCount", memberId);
	}

	@Override
	public int updateClearLockCount(String memberId) {
		return getSqlSession().update(ME + ".updateClearLockCount", memberId);
	}

}
