package com.bewithme.www.service;


import com.bewithme.www.domain.SubjectVO;

public interface SubjectService {


	SubjectVO getTitle(int sub_num);

	int courseCount(int sub_num);
	
}
