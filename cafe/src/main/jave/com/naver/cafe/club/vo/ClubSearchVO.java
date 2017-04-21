package com.naver.cafe.club.vo;

public class ClubSearchVO {

	/*
	 * 페이징을 위한 검색 조건
	 */
	
	private String pageNo;
	private int endArticleNumber;
	private int startArticleNumber;
	
	/*
	 * 검색을 위한 조건
	 */
	private String menuId;
	private String subjectKeyword;
	
	public String getSubjectKeyword() {
		return subjectKeyword;
	}

	public void setSubjectKeyword(String subjectKeyword) {
		this.subjectKeyword = subjectKeyword;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public int getEndArticleNumber() {
		return endArticleNumber;
	}

	public void setEndArticleNumber(int endArticleNumber) {
		this.endArticleNumber = endArticleNumber;
	}

	public int getStartArticleNumber() {
		return startArticleNumber;
	}

	public void setStartArticleNumber(int startArticleNumber) {
		this.startArticleNumber = startArticleNumber;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
}
