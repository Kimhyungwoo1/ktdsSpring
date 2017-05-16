package com.naver.cafe.member.biz;

import com.naver.cafe.member.vo.MemberVO;

public interface MemberBiz {

	public boolean addMember(MemberVO memberVO);
	
	public MemberVO loginMember(MemberVO memberVO);
	
	public String getSalt(String memberId);
	
	public boolean plusLoginFailCount(String memberId);
	
	public boolean updateLockStatus(String memberId);
	
	public boolean selectLockStatus(String memberId);
	
	public boolean updateClearLoginFailCount(String memberId);
	
	public boolean updateClearLockCount(String memberId);
}
