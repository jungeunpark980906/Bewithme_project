package com.bewithme.www.repository;

import java.util.List;

import com.bewithme.www.domain.TodoVO;

public interface TodoDAO {

	int insertTodo(TodoVO todo);

	List<TodoVO> getList(String id);

	int updateTodo(int todo_num);

	String selectIsDel(int todo_num);

	int deleteTodo(int todo_num);

}
