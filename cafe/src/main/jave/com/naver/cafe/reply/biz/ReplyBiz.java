package com.naver.cafe.reply.biz;

import java.util.List;

import com.naver.cafe.reply.vo.ReplyVO;

public interface ReplyBiz {

	public List<ReplyVO> getReplies(String articleId);
	
	public boolean addReply(ReplyVO replyVO);
}
