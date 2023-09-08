package com.bewithme.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/qna/*")
@Controller
public class QnaController {
	
	@GetMapping("/qna")
	public String qna(){
		return "/qna/qna";
	}
	
	@GetMapping("/qna/admin")
	public String qna_admin(){
		return "/qna/qna_admin";
	}
}
