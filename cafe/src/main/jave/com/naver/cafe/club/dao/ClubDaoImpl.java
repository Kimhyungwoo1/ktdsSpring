package com.naver.cafe.club.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;

public class ClubDaoImpl extends SqlSessionDaoSupport implements ClubDao{

	@Override
	public int selectAllClubCount(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectOne(NS + ".selectAllClubCount", clubSearchVO);
	}

	@Override
	public List<ClubVO> selectAllClub(ClubSearchVO clubSearchVO) {
		return getSqlSession().selectList(NS + ".selectAllClub", clubSearchVO);
	}

	@Override
	public int insertNewClub(ClubVO newClubVO) {
		return getSqlSession().insert(NS + ".insertNewClub", newClubVO);
	}

	@Override
	public ClubVO selectOneClub(ClubVO clubVO) {
		return getSqlSession().selectOne(NS + ".selectOneClub", clubVO);
	}

}
