package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;
import model.UpdateLogic;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String priority = request.getParameter("priority");
		String content = request.getParameter("content");
		String date = request.getParameter("date");

		int no;
		String errorMsg = "";

		if (content == null || content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if (date == null || date.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}
		if (!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
			dispatcher.forward(request, response);
			return;
		}

		try {
			no = Integer.parseInt(request.getParameter("no"));
		} catch (NumberFormatException e) {
			request.setAttribute("errorMsg", "TODOリストが存在しません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
			dispatcher.forward(request, response);
			return;
		}

		Todo todo = new Todo(no, priority, content, date);

		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(todo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);

	}

}
