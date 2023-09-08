package com.bewithme.www.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bewithme.www.domain.CommunityVO;

public interface CommunityDAO {

	int insert(CommunityVO cvo);

	List<CommunityVO> selectListByLatest();
	
	List<CommunityVO> selectListByPopularity();

	List<CommunityVO> selectRecommendList();

	CommunityVO selectOne(int com_num);

	int updateCom_cnt(int com_num);

	int updateLike(@Param("com_num") int com_num, @Param("com_like_cnt") int com_like_cnt);

	int updateCom_comment_cntUp(int com_num);

	int updateCom_comment_cntDown(int com_num);

	List<CommunityVO> selectSearchList(String searchKeyword);

	int updateCommunity(CommunityVO cvo);

	int deleteCommunity(int com_num);

	int selectCom_num();



}
