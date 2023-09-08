package com.bewithme.www.service;

import java.util.List;

import com.bewithme.www.domain.ChatBotVO;

public interface ChatBotService {

	int registerChatBot(ChatBotVO cbvo);

	List<ChatBotVO> getList();

}
