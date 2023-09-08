package com.bewithme.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bewithme.www.domain.ChatBotVO;
import com.bewithme.www.repository.ChatBotDAO;

@Service
public class ChatBotServiceImpl implements ChatBotService {

	@Inject
	private ChatBotDAO chatBotDAO;

	@Override
	public int registerChatBot(ChatBotVO cbvo) {
		// TODO Auto-generated method stub
		int isOk=chatBotDAO.insertChatBot(cbvo);
		return isOk;
	}

	@Override
	public List<ChatBotVO> getList() {
		// TODO Auto-generated method stub
		List<ChatBotVO> list = chatBotDAO.getList();
		return list;
	}
}
