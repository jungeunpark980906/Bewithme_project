package com.bewithme.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.www.domain.BookmarkVO;
import com.bewithme.www.domain.CourseVO;
import com.bewithme.www.domain.UserVO;
import com.bewithme.www.service.BookmarkService;

@Controller
@RequestMapping("/bookmark/*")
public class BookmarkController {

	private static final Logger log = LoggerFactory.getLogger(BookmarkController.class);
	
	@Inject
	private BookmarkService bsv;
	
	//북마크 페이지로 이동
	@GetMapping("/bookmarkpage")
	public String bookmarkPage() {
		return "/subject/bookmark";
	}
	
	//북마크 리스트 출력
	@GetMapping(value = "/bookmarkList", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> selectBookmarkList(HttpServletRequest request){
		
		//현재 로그인한 id
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses");
		String id = sesUser.getId();
				
		//북마크 리스트와 전체 수업리스트를 담을 map
		Map<String, Object> listMap = new HashMap<>(); 
		
		//해당id가 담은 수업글 번호리스트
		List<Integer> BookmarkList = bsv.getBookMarkNum(id); 
		listMap.put("BookmarkList", BookmarkList);
		log.info(">>> BookmarkList :"+BookmarkList);
		
		//전체 수업 강의 리스트
    	List<CourseVO> CourseList = bsv.selectCourseList();
        listMap.put("CourseList", CourseList);
        log.info(">>> CourseList :"+CourseList);
        
		return new ResponseEntity<>(listMap, HttpStatus.OK);
	}
	
	//북마크 삭제
	@DeleteMapping(value="/{cou_num}", produces = {MediaType.TEXT_PLAIN_VALUE})
	private ResponseEntity<String> deleteBookmark(@PathVariable("cou_num")int cou_num, HttpServletRequest request){
		log.info(">>> delete cou_num : "+ cou_num);
		//현재 로그인한 id
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses");
		String id = sesUser.getId();
		
		BookmarkVO bvo = new BookmarkVO(id, cou_num);
		
		int isOk = bsv.deleteBookmark(bvo);
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//main에 나의 북마크 리스트 출력
	@GetMapping(value = "/getmainbookmark/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String, Object>> getmainbookmark( @PathVariable("id")String id){
		
		log.info(">>> id :" + id);
		
		//북마크 리스트와 전체 수업리스트를 담을 map
		Map<String, Object> listMap = new HashMap<>(); 		
		
		//해당id가 담은 수업글 북마크 번호리스트
		List<Integer> BookmarkList = bsv.getBookMarkNum(id); 
		listMap.put("bookmarkList", BookmarkList);
		log.info(">>> bookmarkList :"+BookmarkList);
		
		//전체 수업 강의 리스트
    	List<CourseVO> CourseList = bsv.selectCourseList();
        listMap.put("courseList", CourseList);
        log.info(">>> courseList :"+CourseList);
        
		return new ResponseEntity<>(listMap, HttpStatus.OK);
	}


	
	
}
	
	
	
	
	
	
	
