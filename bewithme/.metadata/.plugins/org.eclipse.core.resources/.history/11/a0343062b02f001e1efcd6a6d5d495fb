package com.bewithme.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bewithme.www.domain.CommunityVO;
import com.bewithme.www.domain.Community_LikeVO;

public interface CommunityService {

	int insertCommunity(CommunityVO cvo);

	List<CommunityVO> selectComunnityListByLatest();
	
	List<CommunityVO> selectComunnityListByPopularity();	

	List<CommunityVO> selectRecommendList();

	CommunityVO detailCommunity(int com_num);

	int updateCommunityCount(int com_num);

	int updateCommunityLike(Community_LikeVO clvo);

	List<Integer> getLikeCommentCnt(String id);

	List<CommunityVO> selectComunnitySearchList(String searchKeyword);

	int updateCommunity(CommunityVO cvo);

	int deleteCommunity(int com_num);



}
