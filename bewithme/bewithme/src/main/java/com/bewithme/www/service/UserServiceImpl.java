package com.bewithme.www.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bewithme.www.domain.UserVO;
import com.bewithme.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO udao;
	@Inject
	BCryptPasswordEncoder passwordencoder;

	@Override
	public int signup(UserVO user) {
		// TODO Auto-generated method stub
		log.info(">>> 회원가입 service 진입");
		UserVO tempUser = udao.getUser(user.getId());
		if(tempUser !=null) {
			return 0;
		}
		if(user.getId() == null || user.getId().length() == 0) {
			return 0;
		}
		if(user.getPw() == null || user.getPw().length() == 0) {
			return 0;
		}
		String pw = user.getPw();
		//encode(암호화) / matches(원래 비번, 암호화된 비번)
		String encodePw = passwordencoder.encode(pw); //기존 패스워드 암호화
		//uvo의 패스워드를 암호화된 패스워드로 수정
		user.setPw(encodePw);
		//회원가입 => insert
		int isOk = udao.insertUser(user);
		
		return isOk;
	}

	@Override
	public UserVO isUser(String id, String pw) {
		log.info(">> login Service in");
		UserVO user = udao.getUser(id);
		if(user == null) { return null; }
		if(passwordencoder.matches(pw, user.getPw())) {
			return user;
		}else {
			return null;			
		}
	}
}
