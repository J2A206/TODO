<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String[] todoArray = { "Linuxテスト対策", "paiza", "TODOアプリ", "履歴書作成" };
Date date = new Date();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリ出力画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>片山森斗のTODOリスト</h2>
<table border='1'>
<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>

<%
for (int i = 1; i <= 10; i++) {
	int index = new Random().nextInt(4);
	String todo = todoArray[index];

	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	String today = sdf.format(date);

	out.println("<tr><th>" + i + "</th><th>" + (index + 1) + "</th><th>" + todo + "</th><th>" + today + "</th></tr>");
}
%>

</body>
</html>