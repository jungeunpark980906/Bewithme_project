package com.bewithme.www.service;

import java.util.List;

import com.bewithme.www.domain.Cou_CommentVO;

public interface Cou_CommentService {

	int register(Cou_CommentVO ccvo);

	List<Cou_CommentVO> getList(int cou_num);

	int edit(Cou_CommentVO ccvo);

	int remove(int cou_com_num);

}
