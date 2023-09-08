package com.bewithme.www.repository;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bewithme.www.domain.Com_CommentVO;
import com.bewithme.www.domain.Com_Comment_LikeVO;

public interface Com_CommentDAO {

	int insert(Com_CommentVO ccvo);

	List<Com_CommentVO> selectList(int com_num);

	int update(Com_CommentVO ccvo);

	int delete(int com_com_num);

	int getCom_num(int com_com_num);


	int updateLike(@Param("com_com_num") int com_com_num, @Param("com_com_like_cnt") int com_com_like_cnt);

}
