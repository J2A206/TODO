package model;

import dao.TodoDAO;

public class UpdateLogic {

	public void execute(Todo todo) {
		TodoDAO todoDAO = new TodoDAO();
		todoDAO.update(todo);

	}

}
