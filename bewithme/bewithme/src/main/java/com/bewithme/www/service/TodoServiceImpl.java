package com.bewithme.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bewithme.www.domain.CalendarVO;
import com.bewithme.www.domain.TodoVO;
import com.bewithme.www.repository.TodoDAO;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Inject
	private TodoDAO todoDAO;

	@Override
	public int insertTodo(TodoVO todo) {
		// TODO Auto-generated method stub
		int isOk=todoDAO.insertTodo(todo);
		return isOk;
	}

	@Override
	public List<TodoVO> getList(String id) {
		// TODO Auto-generated method stub
		List<TodoVO>list=todoDAO.getList(id);
		return list;
	}

	@Override
	public int deleteTodo(int todo_num) {
		// TODO Auto-generated method stub
		String isDel=todoDAO.selectIsDel(todo_num);
		int isOk=0;
		if(isDel.equals("y")) {
			isOk=todoDAO.deleteTodo(todo_num);
		}else {			
			isOk=todoDAO.updateTodo(todo_num);
		}
		return isOk;
	}

}
