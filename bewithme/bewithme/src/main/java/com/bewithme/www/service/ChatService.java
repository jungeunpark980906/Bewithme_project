package com.bewithme.www.service;

import java.util.List;

import com.bewithme.www.domain.ChatVO;

public interface ChatService {

	int insertMsg(ChatVO chat);

	List<ChatVO> getList(String fromId);

	List<ChatVO> getUserList();

}
