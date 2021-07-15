package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InputLogic;
import model.Todo;
import model.User;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("/J2A206/index.jsp");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/J2A206/index.jsp");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
		dispatcher.forward(request, response);
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

		HttpSession session = request.getSession();
		User user= (User)session.getAttribute("user");

		Todo todo = new Todo(priority, content, date, user.getName());
		InputLogic inputLogic = new InputLogic();
		inputLogic.execute(todo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);




	}

}
