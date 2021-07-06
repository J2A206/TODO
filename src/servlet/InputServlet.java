package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>TODOアプリ出力結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>TODOアプリケーション</h1>");
		out.println("<h2>片山森斗のTODOリスト</h2>");
		out.println("<p>" + errorMsg + "</p>");
		out.println("<table border=\"1\">");
		out.println("<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>");
		out.println(
				"<tr><th>1</th><th>" + priority + "</th><th>" + content + "</th><th>" + date + "</th></tr>");
		out.println("</body>");
		out.println("</html>");


	}

}
