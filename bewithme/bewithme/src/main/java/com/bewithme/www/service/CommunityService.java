package com.bewithme.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bewithme.www.domain.Com_FileVO;
import com.bewithme.www.domain.CommunityDTO;
import com.bewithme.www.domain.CommunityVO;
import com.bewithme.www.domain.Community_LikeVO;

public interface CommunityService {

	int insertCommunity(CommunityVO cvo);

	List<CommunityVO> selectComunnityListByLatest();
	
	List<CommunityVO> selectComunnityListByPopularity();	

	List<CommunityVO> selectRecommendList();

	CommunityDTO detailCommunity(int com_num);

	int updateCommunityCount(int com_num);

	int updateCommunityLike(Community_LikeVO clvo);

	List<Integer> getLikeCommentCnt(String id);

	List<CommunityVO> selectComunnitySearchList(String searchKeyword);

	int updateCommunity(CommunityVO cvo);

	int deleteCommunity(int com_num);

	int insertCommunityfile(List<Com_FileVO> fList);

	List<Com_FileVO> getThumbImg();

	int removeFile(String uuid);

	CommunityVO getMainCommunity();

	int modCommunityfile(List<Com_FileVO> fList, int com_num);

	String SummerNoteImageFile(MultipartFile file);



}
