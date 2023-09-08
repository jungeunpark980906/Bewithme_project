package com.bewithme.www.controller;

import java.util.List;

import javax.inject.Inject;

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

import com.bewithme.www.domain.CalendarVO;
import com.bewithme.www.domain.TodoVO;
import com.bewithme.www.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/todo/*")
@Controller
public class TodoController {
	
	@Inject
	private TodoService todoService;
	
	
	@PostMapping(value="/register",consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registerTodo(Model m, @RequestBody TodoVO todo) {
		int isOk=todoService.insertTodo(todo);
		
		return isOk> 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@GetMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TodoVO>> getScheduleList(Model m){
		List<TodoVO> list=todoService.getList();
		return new ResponseEntity<List<TodoVO>>(list,HttpStatus.OK);
	}
	
	@PutMapping(value="/remove/{todo_num}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeTodo(@PathVariable("todo_num")int todo_num){
		log.info(">>>>>remove todo_num " + todo_num);
		int isOk = todoService.deleteTodo(todo_num);
		return isOk>0?
				new ResponseEntity<String>("1",HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
