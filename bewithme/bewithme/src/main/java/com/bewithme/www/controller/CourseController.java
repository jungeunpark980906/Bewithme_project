package com.bewithme.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bewithme.www.domain.BookmarkVO;
import com.bewithme.www.domain.CourseVO;
import com.bewithme.www.domain.UserVO;
import com.bewithme.www.service.CourseService;

import lombok.extern.slf4j.Slf4j;



@RequestMapping("/co/*")
@Slf4j
@Controller
public class CourseController {
	@Inject
	private CourseService csv;
	
	
	@GetMapping("/write")
	public String write(CourseVO cvo, @RequestParam("sub_num") int sub_num, Model m) {
		log.info("sub_num"+ sub_num);
		m.addAttribute("sub_num", sub_num);
		return "/subject/course_reg";
	}
	
	@PostMapping("/write")
	public String insertCourse(CourseVO cvo, RedirectAttributes r, Model m) {
		log.info(">>>>>>>> 50 cvo : "+ cvo);
		int isOk = csv.insertCourse(cvo);
//		csv.insertCourse(cvo,cvo.getSub_num());
		r.addFlashAttribute("msg", isOk);
//		m.addAttribute("msg",isOk);
		return "redirect:/sj/title?sub_num="+cvo.getSub_num();
	}
	
	@GetMapping("/link")
	public String link(@RequestParam("cou_num")int cou_num, Model m,HttpServletRequest request) {
		log.info(">>>cou_num : "+cou_num);
		CourseVO cvo  = csv.getTitleContent(cou_num);
		log.info(">>>cvo : "+cvo);
		m.addAttribute("cvo",cvo);
		
		int cou_cnt = csv.cou_cnt(cou_num);
		
		//북마크 넘어갈때 id = cou_num 가 같을때 북마크 유지
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses"); 
		
		BookmarkVO bookvo = new BookmarkVO(0,sesUser.getId(),cou_num);
		log.info(">>>아이디 :"+sesUser.getId());
		
		int isOk = csv.booklist(bookvo);
		log.info(">>> isOk : " + isOk);
		m.addAttribute("isOk",isOk);
			
		return "/subject/course2";
	}
	
//	@GetMapping("/link")
//	public String link(@RequestParam("cou_num")int cou_num, Model m) {
//		log.info(">>>cou_num : "+cou_num);
//		CourseVO cvo  = csv.getTitleContent(cou_num);
//		log.info(">>>cvo : "+cvo);
//		m.addAttribute("cvo",cvo);
//		
//		int cou_cnt = csv.cou_cnt(cou_num);
//			
//		return "/subject/course2";
//	}
	
//	//북마크 업데이트
//	@GetMapping(value="/updateBookmark/{cnoVal}", produces = {MediaType.TEXT_PLAIN_VALUE})
//	public ResponseEntity<String> updatebookmark(@PathVariable("cnoVal") int cou_num, HttpServletRequest request){
//		log.info(">>> cou_num : "+ cou_num);
//		HttpSession ses = request.getSession();
//		UserVO sesUser = (UserVO)ses.getAttribute("ses");  
//		
//		BookmarkVO bookvo = new BookmarkVO(0, sesUser.getId(),cou_num);
//		
//		int isOk = csv.updateBookmark(bookvo);
//		log.info(">>> isOk : " + isOk);
//		
//		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
//				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
	
	//게시글 수정글 가지고옴
	@GetMapping("/mod_link")
	public String mod_link(@RequestParam("cou_num")int cou_num, Model m) {
		log.info(">>>cou_num : "+cou_num);
		CourseVO cvo  = csv.getTitleContent(cou_num);
		log.info(">>>cvo : "+cvo);
		m.addAttribute("msg",cvo);
		
//		int cou_cnt = csv.cou_cnt(cou_num);
			
		return "/subject/course_mod";
	}
	
	//게시글 수정 업데이트
	@PostMapping("/modify")
	public String cou_modify(CourseVO cvo,RedirectAttributes r) {
		log.info(">>> modify cvo : "+ cvo);

		int isOk = csv.modifyCourse(cvo);
		r.addFlashAttribute("mod", isOk);
		return "redirect:/sj/title?sub_num="+cvo.getSub_num();
	}
	

	//각 과목에 대한 강의 리스트	
	@GetMapping(value = "/{sub_num}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CourseVO>> spread(@PathVariable("sub_num")int sub_num){
		log.info(">>> course list sub_num : "+sub_num);
		List<CourseVO> list = csv.getList(sub_num);
		log.info(">>> courst_List : " + list.toString());
		
		return new ResponseEntity<List<CourseVO>>(list, HttpStatus.OK);
	}
	
	//강의 삭제	
	@DeleteMapping(value = "/{cou_num}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("cou_num")int cou_num){
		log.info(">>> remove cou_num : "+cou_num);
		
		int isOk = csv.remove(cou_num);
		return isOk > 0?
				new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//북마크 업데이트
	@GetMapping(value="/updateBookmark/{cnoVal}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updatebookmark(@PathVariable("cnoVal") int cou_num, HttpServletRequest request){
		log.info(">>> cou_num : "+ cou_num);
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses");  
		
		BookmarkVO bookvo = new BookmarkVO(0, sesUser.getId(),cou_num);
		
		int isOk = csv.updateBookmark(bookvo);
		log.info(">>> isOk : " + isOk);
		
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//썸머노트 이미지 변환
	  @RequestMapping(value="/SummerNoteImageFile" , method = RequestMethod.POST)
		public @ResponseBody String SummerNoteImageFile(@RequestParam("file") MultipartFile file) {
			String url = csv.SummerNoteImageFile(file);
			 System.out.println(url);
			return url;
		}
	

	
}
