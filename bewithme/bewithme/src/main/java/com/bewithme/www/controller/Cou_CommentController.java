package com.bewithme.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.www.domain.Cou_CommentVO;
import com.bewithme.www.service.Cou_CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cou_comment/*")
@Controller
public class Cou_CommentController {
	
	@Inject
	private Cou_CommentService ccsv;
	
	@PostMapping(value = "/post", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE} )
	public ResponseEntity<String> post(@RequestBody Cou_CommentVO ccvo){
		log.info(">>> ccvo : "+ ccvo);
		//id 임시연결
		//ccvo.setId("123");
		//DB연결
		int isOk = ccsv.register(ccvo);
		return isOk > 0 ? new ResponseEntity<String>("1",HttpStatus.OK) : new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping(value="/{cou_num}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Cou_CommentVO>> spread(@PathVariable("cou_num")int cou_num){
		log.info(">>>cou_comment List cou_num : "+cou_num);
		List<Cou_CommentVO>list = ccsv.getList(cou_num);
		return new ResponseEntity<List<Cou_CommentVO>>(list,HttpStatus.OK);
	}
	
	@PutMapping(value = "/edit", consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> edit(@RequestBody Cou_CommentVO ccvo){
		log.info(">>> edit ccvo : "+ccvo);
		//id 임시연결
		//ccvo.setId("123");
		//DB연결
		int isOk = ccsv.edit(ccvo);
		return isOk > 0 ? new ResponseEntity<String>("1",HttpStatus.OK) : new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{cou_com_num}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("cou_com_num")int cou_com_num){
		log.info(">>> remove cou_com_num : "+ cou_com_num);
		
		int isOk = ccsv.remove(cou_com_num);
		return isOk > 0?
				new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
