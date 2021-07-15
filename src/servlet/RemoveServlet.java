package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RemoveLogic;

@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no;
		String errorMsg = "";

		try {
			no = Integer.parseInt(request.getParameter("no"));
		} catch (NumberFormatException e) {
			request.setAttribute("removeErrorMsg", "TODOリストが存在しません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
			dispatcher.forward(request, response);
			return;
		}
		RemoveLogic removeLogic = new RemoveLogic();
		removeLogic.execute(no);

		RequestDispatcher dispatcher = request.getRequestDispatcher("ListServlet");
		dispatcher.forward(request, response);

	}

}
