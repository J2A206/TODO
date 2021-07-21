package model;

import dao.usersDAO;

public class LoginLogic {
	public boolean execute(User users) {
		usersDAO dao = new usersDAO();
		User user = dao.findByLogin(users);
		return user != null;
	}

}
