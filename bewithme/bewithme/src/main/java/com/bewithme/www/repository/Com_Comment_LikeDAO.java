package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.Com_Comment_LikeVO;

public interface Com_Comment_LikeDAO {

	int delete(Com_Comment_LikeVO cclvo);

	int selectLikeCnt(int com_com_num);

	int insert(Com_Comment_LikeVO cclvo);

	int isLike(Com_Comment_LikeVO cclvo);

	List<Integer> getLikeCom_CommentCnt(String id);

	int deleteAllCommentLike(int com_com_num);

}
