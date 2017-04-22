package com.naver.cafe.club.service;

import java.util.HashMap;
import java.util.Map;

import com.naver.cafe.club.biz.ClubBiz;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.menu.biz.MenuBiz;
import com.naver.cafe.menu.vo.MenuSearchVO;
import com.naver.cafe.reply.biz.ReplyBiz;

public class ClubServiceImpl implements ClubService{

	private MenuBiz menuBiz;
	private ClubBiz clubBiz;
	private ReplyBiz replyBiz;
	
	public void setReplyBiz(ReplyBiz replyBiz) {
		this.replyBiz = replyBiz;
	}
	
	public void setClubBiz(ClubBiz clubBiz) {
		this.clubBiz = clubBiz;
	}
	
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
	
	@Override
	public ClubListVO getAllClub(ClubSearchVO clubSearchVO) {
		
		ClubListVO clubListVO = clubBiz.getAllClub(clubSearchVO);
		
		MenuSearchVO menuSearchVO = new MenuSearchVO();
		menuSearchVO.setAuth("ADM");
		
		clubListVO.setMenuList(menuBiz.getAllMenu(menuSearchVO));
		
		menuSearchVO.setMenuId(clubSearchVO.getMenuId());
		clubListVO.setCurrentMenu( menuBiz.getAllMenu(menuSearchVO) );
		
		return clubListVO;
	}

	@Override
	public boolean addNewClub(ClubVO newClubVO) {
		return clubBiz.addNewClub(newClubVO);
	}

	@Override
	public Map<String, Object>getOneClub(ClubVO clubVO) {
		
		ClubVO clubVOs = clubBiz.getOneClub(clubVO);
		clubVOs.setReplyVO(replyBiz.getReplies(clubVO.getArticleId()));
		
		Map<String, Object> club = new HashMap<String, Object>();
		club.put("club", clubVOs);
		
		MenuSearchVO menuSearchVO = new MenuSearchVO();
		menuSearchVO.setAuth("ADM");
		
		club.put("menu", menuBiz.getAllMenu(menuSearchVO));
		
		menuSearchVO.setMenuId( clubVO.getMenuId());
		club.put("currentMenu", menuBiz.getAllMenu(menuSearchVO) );
		
		return club;
	}

	@Override
	public boolean addReadCount(ClubVO clubVO) {
		return clubBiz.addReadCount(clubVO);
	}
	
}