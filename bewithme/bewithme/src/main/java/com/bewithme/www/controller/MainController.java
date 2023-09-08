package com.bewithme.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/main/*")
@Controller
public class MainController {
	@GetMapping("/main")
	public String main(){
		return "/main/main";
	}
	@GetMapping("/start")
	public String start(){
		return "/main/start";
	}
	@GetMapping("/end")
	public String end(){
		return "/main/end";
	}
	@GetMapping("/likeList")
	public String likeList(){
		return "/subject/bookmark";
	}
	@GetMapping("/community")
	public String community(){
		return "/community/community";
	}
}
