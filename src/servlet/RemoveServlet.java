package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RemoveLogic;
import model.Todo;

@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		String errorMsg = "";

		try {
			no = Integer.parseInt(request.getParameter("no"));
		} catch (NumberFormatException e) {
			request.setAttribute("removeErrorMsg", "TODOリストが存在しません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}

		RemoveLogic removeLogic = new RemoveLogic();
		removeLogic.execute(no, todoList);

		session.setAttribute("todoList", todoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}

}
