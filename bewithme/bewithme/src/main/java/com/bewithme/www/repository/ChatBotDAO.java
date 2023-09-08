package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.ChatBotVO;

public interface ChatBotDAO {

	int insertChatBot(ChatBotVO cbvo);

	List<ChatBotVO> getList();

}
