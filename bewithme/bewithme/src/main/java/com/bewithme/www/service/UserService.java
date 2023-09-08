package com.bewithme.www.service;

import com.bewithme.www.domain.UserVO;

public interface UserService {

	int signup(UserVO user);

	UserVO isUser(String id, String pw);
	
}
