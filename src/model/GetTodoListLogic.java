package model;

import java.util.List;

import dao.TodoDAO;

public class GetTodoListLogic {

	public List<Todo> execute(String userName) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.find(userName);
	}

}