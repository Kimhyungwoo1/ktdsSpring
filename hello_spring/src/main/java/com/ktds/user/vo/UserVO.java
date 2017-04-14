package com.ktds.user.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVO {

	@NotEmpty(message="아이디를 입력하세요.")
	private String userId;
	
	@NotEmpty(message="이름을 입력하세요.")
	private String userName;
	
	@NotEmpty(message="비밀번호를 입력하세요.")
	@Length(min=8, message="8자 이상 입력하세요.")
	private String userPassword;
	private String joinDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
