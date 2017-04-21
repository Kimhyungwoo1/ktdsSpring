package com.naver.cafe.reply.vo;

import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.member.vo.MemberVO;

public class ReplyVO {

	private int level;
	private String replyId;
	private String articleId;
	private String memberId;
	private String content;
	private String createDate;
	private String recommendCount;
	private String parentReplyId;

	private ClubVO clubVO;
	private MemberVO memberVO;
	private ReplyVO parentReplyVO;
	
	public ClubVO getClubVO() {
		return clubVO;
	}

	public void setClubVO(ClubVO clubVO) {
		this.clubVO = clubVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ReplyVO getParentReplyVO() {
		return parentReplyVO;
	}

	public void setParentReplyVO(ReplyVO parentReplyVO) {
		this.parentReplyVO = parentReplyVO;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(String recommendCount) {
		this.recommendCount = recommendCount;
	}

	public String getParentReplyId() {
		return parentReplyId;
	}

	public void setParentReplyId(String parentReplyId) {
		this.parentReplyId = parentReplyId;
	}

}
