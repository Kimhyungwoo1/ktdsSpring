package com.naver.cafe.club.biz;

import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public interface ClubBiz {

	public ClubListVO getAllClub(ClubSearchVO clubSearchVO);
	
	public boolean addNewClub(ClubVO newClubVO);
	
	public ClubVO getOneClub(ClubVO clubVO);
	
	public boolean addReadCount(ClubVO clubVO);
}
