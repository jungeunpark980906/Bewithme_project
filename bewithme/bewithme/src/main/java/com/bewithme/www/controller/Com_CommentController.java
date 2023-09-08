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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.www.domain.Com_CommentVO;
import com.bewithme.www.domain.Com_Comment_LikeVO;
import com.bewithme.www.domain.UserVO;
import com.bewithme.www.service.Com_CommentService;

@Controller
@RequestMapping("/com_comment/*")
public class Com_CommentController {

	private static final Logger log = LoggerFactory.getLogger(Com_CommentController.class);
	 
	@Inject
	private Com_CommentService ccsv; 
	
	//댓글 저장
	@PostMapping(value="/insert", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertComment(@RequestBody Com_CommentVO ccvo, HttpServletRequest request){
	
		log.info(">>> ccvo : " + ccvo.toString());
		
		int isOk = ccsv.insertCom_Comment(ccvo);
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 리스트 출력
	@GetMapping(value="/commentList/{com_num}", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<Map<String, Object>> selectCom_CommentList(@PathVariable("com_num") int com_num, HttpServletRequest request,
				Model m){
		
		log.info(">>> com_com_num : " +com_num);
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses");
		Map<String, Object> listMap = new HashMap<>(); 
		

		//해당 id가 좋아요한 댓글 리스트
		String id = sesUser.getId();
		List<Integer> likeList = ccsv.getLikeCom_CommentCnt(id); 
		log.info(">>> likeList :"+likeList);
		listMap.put("likeList", likeList);
		
		//해당 게시글의 댓글 전체 리스트
		List<Com_CommentVO> commentList = ccsv.selectCom_commentList(com_num);
		log.info(">>> com_List : " +commentList.toString());
		listMap.put("commentList", commentList);
		
		return new ResponseEntity<>(listMap, HttpStatus.OK);     
	}
	
	//댓글 수정
	@PutMapping(value="/{com_com_num}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	private ResponseEntity<String> modifyComment(@PathVariable("com_com_num") int com_com_num, @RequestBody Com_CommentVO ccvo){
		log.info(">>> modify com_com_num : "+ com_com_num);
		log.info(">>> modify ccvo : "+ ccvo);
		
		int isOk = ccsv.modifyCom_Comment(ccvo);
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
	//댓글 삭제
	@DeleteMapping(value="/{com_com_num}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	private ResponseEntity<String> deleteComment(@PathVariable("com_com_num")int com_com_num){
		log.info(">>> delete com_com_num : "+ com_com_num);
	
		
		int isOk = ccsv.deleteCom_Comment(com_com_num);
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	//댓글 좋아요
	@GetMapping(value="/updateLike/{btnVal}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateCommunityLike(@PathVariable("btnVal") int com_com_num, HttpServletRequest request){
		
		log.info(">>> com_com_num : " + com_com_num);
		HttpSession ses = request.getSession();
		UserVO sesUser = (UserVO)ses.getAttribute("ses");  
		log.info(">>> ses.id : " + sesUser.getId());
		Com_Comment_LikeVO cclvo = new Com_Comment_LikeVO(sesUser.getId(), com_com_num);
		
		int isOk = ccsv.updateCom_CommentLike(cclvo);
		log.info(">>> isOk : " + isOk);
		
		return isOk > 0? new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}

