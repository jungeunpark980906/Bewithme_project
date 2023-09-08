package com.bewithme.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.www.domain.ChatBotVO;
import com.bewithme.www.service.ChatBotService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/chatbot/*")
@Controller
public class ChatBotController {

	@Inject
	private ChatBotService chatBotService;
	
	@PostMapping(value = "/register", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	private ResponseEntity<String> registerChatBot(Model m,@RequestBody ChatBotVO cbvo){
		log.info("챗봇 객체 : "+cbvo);
		int isOk=chatBotService.registerChatBot(cbvo);
		
		return isOk>0 ? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<ChatBotVO>> getChatBotList(Model m){
		List<ChatBotVO> list = chatBotService.getList();
		
		return new ResponseEntity<List<ChatBotVO>>(list,HttpStatus.OK);
	}
	
}
