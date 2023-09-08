package com.bewithme.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bewithme.www.domain.BookmarkVO;
import com.bewithme.www.domain.CourseVO;
import com.bewithme.www.repository.BookmarkDAO;
import com.bewithme.www.repository.CourseDAO;

@Service
public class BookmarkServiceImpl implements BookmarkService{

	@Inject
	private BookmarkDAO bdao;
	@Inject
	private CourseDAO cdao;

	@Override
	public List<Integer> getBookMarkNum(String id) {
		// 해당 id가 담은 강의 번호 리스트
		return bdao.selectBookmarkNum(id);
	}

	@Override
	public List<CourseVO> selectCourseList() {
		// 강의 전체 리스트 
		return cdao.selectAllList();
	}

	@Override
	public int deleteBookmark(BookmarkVO bvo) {
		// 강의 삭제
		return bdao.deleteBookmark(bvo);
	}
}
