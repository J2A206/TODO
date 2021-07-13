package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todo;
import model.TodoComparator;
import model.UpdateLogic;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		String priority = request.getParameter("priority");
		String content = request.getParameter("content");
		String date = request.getParameter("date");

		String errorMsg = "";
		if (content == null || content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if (date == null || date.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}
		if (!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}
		Todo todo = new Todo();
		todo.setPriority(priority);
		todo.setContent(content);
		todo.setDate(date);
		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(no, todo, todoList);

		Collections.sort(todoList, new TodoComparator());
		session.setAttribute("todoList", todoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);

	}

}
