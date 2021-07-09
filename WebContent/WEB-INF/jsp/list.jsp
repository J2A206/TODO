<%@page import="model.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/bootstrap.min.css">
<link rel="shortcut icon" href="images/favicon.ico">
<title>TODOアプリ出力結果</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>片山森斗のTODOリスト</h2>

<table class="table">
<tr>
	<th>No</th>
	<th>重要度</th>
	<th>内容</th>
	<th>期日</th>
</tr>
<tr>
	<td>1</td>
	<td>${ todo.priority }</td>
	<td>${ todo.content }</td>
	<td>${ todo.date }</td>
</tr>
</table>
<input type="button" value = "戻る" onclick="javascript:history.back();">

</body>
</html>