package com.naver.cafe.member.service;

import com.naver.cafe.member.vo.MemberVO;

public interface MemberService {

	public boolean addMember(MemberVO memberVO);
	
	public MemberVO loginMember(MemberVO memberVO);
	
}
