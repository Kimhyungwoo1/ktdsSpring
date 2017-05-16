package com.naver.cafe.club.service;

import java.util.Map;

import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.member.vo.MemberVO;
import com.naver.cafe.reply.vo.ReplyVO;

public interface ClubService {

	public ClubListVO getAllClub(ClubSearchVO clubSearchVO, MemberVO memberVO);
	
	public boolean addNewClub(ClubVO newClubVO);
	
	public Map<String, Object> getOneClub(ClubVO clubVO, MemberVO memberVO);
	
	public boolean addReadCount(ClubVO clubVO);
	
	public boolean addReply(ReplyVO replyVO);
}
