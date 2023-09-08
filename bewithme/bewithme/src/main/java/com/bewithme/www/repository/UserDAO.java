package com.bewithme.www.repository;

import com.bewithme.www.domain.UserVO;

public interface UserDAO {

	UserVO getUser(String id);

	int insertUser(UserVO user);

}
