<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/bootstrap.min.css">
<link rel="shortcut icon" href="images/favicon.ico">

<meta charset="UTF-8">
<title>TODOアプリ入力画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>TODO入力</h2>
<span style="color:red;">${errorMsg }</span>
<form action="InputServlet" method="post">
重要度:<select name="priority">
<option value="5">5</option>
<option value="4">4</option>
<option value="3">3</option>
<option value="2">2</option>
<option value="1">1</option>
</select>
内容:<input type="text" name="content"><br>
期日:<input type="date" name="date"><br>
<input type="submit" name="登録">
<input type="button" value = "戻る" onclick="javascript:history.back();">
</form>
</body>
</html>