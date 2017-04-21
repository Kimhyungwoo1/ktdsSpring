package com.naver.cafe.club.vo;

import com.naver.cafe.member.vo.MemberVO;
import com.naver.cafe.menu.vo.MenuVO;

public class ClubVO {

	private String articleId;
	private String subject;
	private String content;
	private String memberId;
	private String createData;
	private String modifyData;
	private int readCount;
	private String menuId;

	private MemberVO memberVO;
	private MenuVO menuVO;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCreateData() {
		return createData;
	}

	public void setCreateData(String createData) {
		this.createData = createData;
	}

	public String getModifyData() {
		return modifyData;
	}

	public void setModifyData(String modifyData) {
		this.modifyData = modifyData;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public MenuVO getMeunVO() {
		return menuVO;
	}

	public void setMeunVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}

}
