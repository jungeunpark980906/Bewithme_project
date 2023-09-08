package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.ChatVO;

public interface ChatDAO {

	int insertMsg(ChatVO chat);

	List<ChatVO> getList(String fromId);

	List<ChatVO> getUserList();

}
