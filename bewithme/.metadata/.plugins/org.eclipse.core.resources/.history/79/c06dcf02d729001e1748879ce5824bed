package com.bewithme.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.www.domain.CalendarVO;
import com.bewithme.www.domain.UserVO;
import com.bewithme.www.service.CalendarService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/calendar/*")
@Controller
public class CalendarController {
	@Inject
	private CalendarService calService;
	
	@PostMapping(value="/register",consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registerSchedule(Model m, @RequestBody CalendarVO cal) {
		int isOk=calService.insertSchedule(cal);
		
		return isOk> 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarVO>> getScheduleList(Model m){
		List<CalendarVO> list=calService.getList();
		return new ResponseEntity<List<CalendarVO>>(list,HttpStatus.OK);
	}
}
