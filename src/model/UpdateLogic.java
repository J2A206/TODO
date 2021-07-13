package model;

import java.util.List;

public class UpdateLogic {

	public void execute(int no, Todo todo, List<Todo> todoList) {
		todoList.set(no, todo);

	}

}
