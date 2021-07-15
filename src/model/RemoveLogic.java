package model;

import dao.TodoDAO;

public class RemoveLogic {

	public void execute(int no) {
		TodoDAO todoDAO = new TodoDAO();
		todoDAO.delete(no);

	}

}
