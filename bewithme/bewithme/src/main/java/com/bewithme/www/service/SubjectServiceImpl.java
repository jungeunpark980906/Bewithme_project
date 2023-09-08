package com.bewithme.www.service;



import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bewithme.www.domain.SubjectVO;
import com.bewithme.www.repository.CourseDAO;
import com.bewithme.www.repository.SubjectDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {

	@Inject
	private SubjectDAO sdao;
	@Inject
	private CourseDAO cdao;


	@Override
	public SubjectVO getTitle(int sub_num) {
		log.info("title service 진입!!");
		return sdao.getTitle(sub_num);
	}


	@Override
	public int courseCount(int sub_num) {
		log.info("courseCount service 진입!!");
		return cdao.courseCount(sub_num);
	}
	


}
