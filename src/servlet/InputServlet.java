package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/J2A206/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String priority = request.getParameter("priority");
		String content = request.getParameter("content");
		String date = request.getParameter("date");

		String errorMsg = "";
		if(content == null||content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if(date == null||date.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}
		if(!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}

		Todo todo = new Todo();
		todo.setPriority(priority);
		todo.setContent(content);
		todo.setDate(date);
		request.setAttribute("todo", todo);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);




	}

}
