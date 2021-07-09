package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/J2A206/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String errorMsg = "";
		if(name == null||name.length() == 0) {
			errorMsg += "ユーザー名が入力されていません<br>";
		}
		if(pass == null||pass.length() == 0) {
			errorMsg += "パスワードが入力されていません<br>";
		}
		if(!errorMsg.equals("")) {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			return;
		}


		User user = new User(name, pass);
		LoginLogic logic = new LoginLogic();
		if(!logic.execute(user)) {
			errorMsg += "ユーザー名またはパスワードに誤りがあります";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jsp");
		dispatcher.forward(request, response);
	}

}
