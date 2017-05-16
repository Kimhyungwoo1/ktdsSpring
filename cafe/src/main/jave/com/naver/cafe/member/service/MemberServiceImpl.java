package com.naver.cafe.member.service;

import com.naver.cafe.common.utillities.SHA256Util;
import com.naver.cafe.member.biz.MemberBiz;
import com.naver.cafe.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	private MemberBiz memberBiz;
	
	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}

	@Override
	public boolean addMember(MemberVO memberVO) {
		
		String salt = SHA256Util.generateSalt();
		memberVO.setSalt(salt);
		
		String password = memberVO.getMemberPassword();
		password = SHA256Util.getEncrypt(password, salt);
		memberVO.setMemberPassword(password);
		
		memberVO.setAuth("USR");
		
		return memberBiz.addMember(memberVO);
	}

	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		
		// 아이디가 잠긴것이 불려오면 null을 return 한다.
		if ( memberBiz.selectLockStatus(memberVO.getMemberId()) ){
			return null;
		}
		memberBiz.updateClearLoginFailCount(memberVO.getMemberId());
		
		String salt = memberBiz.getSalt(memberVO.getMemberId());
		
		String password = memberVO.getMemberPassword();
		password = SHA256Util.getEncrypt(password, salt);
		memberVO.setMemberPassword(password);
		
		MemberVO member = memberBiz.loginMember(memberVO);
		
		if ( member != null) {
			memberBiz.updateClearLockCount(memberVO.getMemberId());
		}
		else {
			memberBiz.plusLoginFailCount(memberVO.getMemberId());
			memberBiz.updateLockStatus(memberVO.getMemberId());
		}
		
		return member;
	}
	
}
