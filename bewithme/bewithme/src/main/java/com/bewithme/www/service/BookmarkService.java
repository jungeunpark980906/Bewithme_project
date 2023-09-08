package com.bewithme.www.service;

import java.util.List;

import com.bewithme.www.domain.BookmarkVO;
import com.bewithme.www.domain.CourseVO;

public interface BookmarkService {

	List<Integer> getBookMarkNum(String id);

	List<CourseVO> selectCourseList();

	int deleteBookmark(BookmarkVO bvo);

}
