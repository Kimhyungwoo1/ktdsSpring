package com.naver.cafe.member.dao;

import com.naver.cafe.member.vo.MemberVO;

public interface MemberDao {

	public static final String ME = "MemberDao";
	
	public int insertMember(MemberVO memberVO);
	
	public MemberVO selectOneMember(MemberVO memberVO);
	
	public String getSalt(String memberId);
	
	public int plusLoginFailCount(String memberId);
	
	public int updateLockStatus(String memberId);
	
	public int selectLockStatus(String memberId);
	
	public int updateClearLoginFailCount(String memberId);
	
	public int updateClearLockCount(String memberId);
}
