package com.naver.cafe.reply.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.reply.vo.ReplyVO;

public class ReplyDaoImpl extends SqlSessionDaoSupport implements ReplyDao {

	@Override
	public List<ReplyVO> selectAllReplies(String articleId) {
		return getSqlSession().selectList(MS + ".selectAllReplies", articleId);
	}

	@Override
	public int insertReply(ReplyVO replyVO) {
		return getSqlSession().insert(MS + ".insertReply", replyVO);
	}

}
