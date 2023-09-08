package com.bewithme.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bewithme.www.domain.UserVO;
import com.bewithme.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class UserController {
	@Inject
	private UserService userService;
	
	@PostMapping(value="/signup",consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> signupPost(Model m, @RequestBody UserVO user) {
		log.info("회원가입 controller 접근");
		log.info("회원가입 user 정보 >> "+user);
		int isOk=userService.signup(user);
		if(isOk > 0) {
			m.addAttribute("msg_signup", 1);
			log.info("회원가입 성공!");
		}else {
			m.addAttribute("msg_signup", 0);
			log.info("회원가입 실패!");

		}
		return isOk> 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping(value="/login",consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> loginPost(Model m,@RequestBody UserVO user, HttpServletRequest request) {		
		//파라미터로 받은 id, pw를 DB에 넘겨 일치하는 객체를 받음.
		log.info("로그인 user 정보 >> "+user);
		int isOk=0;
		UserVO isUser = userService.isUser(user.getId(),user.getPw()); 
		//DB에서 얻은 객체가 null이 아니라면 세션 연결 저장
		if(isUser != null) {
			HttpSession ses = request.getSession();
			ses.setAttribute("ses", isUser);  //세션에 객체 담기
			ses.setMaxInactiveInterval(60*100); //로그인 유지시간 
			m.addAttribute("user", isUser);
			log.info("로그인 성공!");
			isOk=1;
		}else {
			m.addAttribute("msg_login",0);
		}
		return isOk> 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/logout")
	public String logout(Model m, HttpServletRequest request) {
		request.getSession().removeAttribute("ses");
		request.getSession().invalidate(); //세션끊기
		m.addAttribute("msg_logout", 1);
		return "home";
	}
}
