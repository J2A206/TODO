<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOアプリログイン画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>ログイン</h2>
<span style="color:red;">${errorMsg }</span>
<form action="LoginServlet" method="post">
ユーザー名:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
</body>
</html>