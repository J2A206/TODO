package model;

import dao.TodoDAO;

public class InputLogic {

	public void execute(Todo todo) {
		TodoDAO todoDAO = new TodoDAO();
		todoDAO.create(todo);

	}

}
