package com.naver.cafe.reply.dao;

import java.util.List;

import com.naver.cafe.reply.vo.ReplyVO;

public interface ReplyDao {

	public static final String MS = "ReplyDao";
	
	public List<ReplyVO> selectAllReplies(String articleId);
	
}
