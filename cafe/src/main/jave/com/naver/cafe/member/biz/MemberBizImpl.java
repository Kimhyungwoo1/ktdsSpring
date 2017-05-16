package com.naver.cafe.member.biz;

import com.naver.cafe.member.dao.MemberDao;
import com.naver.cafe.member.vo.MemberVO;

public class MemberBizImpl implements MemberBiz{

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public boolean addMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO) > 0;
	}

	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		return memberDao.selectOneMember(memberVO);
	}

	@Override
	public String getSalt(String memberId) {
		return memberDao.getSalt(memberId);
	}

	@Override
	public boolean plusLoginFailCount(String memberId) {
		return memberDao.plusLoginFailCount(memberId) > 0;
	}

	@Override
	public boolean updateLockStatus(String memberId) {
		return memberDao.updateLockStatus(memberId) > 0;
	}

	@Override
	public boolean selectLockStatus(String memberId) {
		return memberDao.selectLockStatus(memberId) > 0;
	}

	@Override
	public boolean updateClearLoginFailCount(String memberId) {
		return memberDao.updateClearLoginFailCount(memberId) > 0;
	}

	@Override
	public boolean updateClearLockCount(String memberId) {
		return memberDao.updateClearLockCount(memberId) > 0;
	}
}
