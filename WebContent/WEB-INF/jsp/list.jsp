<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body onload="selectboxChange();">
	<p class="lead text-right">
		<a href="LogoutServlet">ログアウト</a>
	</p>
	<h1>TODOアプリケーション</h1>
	<h2>${user.name}のTODOリスト</h2>

	<table class="table" border='1' id="targetTable">
		<tr>
			<th>No</th>
			<th>重要度</th>
			<th>内容</th>
			<th>期日</th>
		</tr>
		<c:forEach var="todo" items="${todoList}" varStatus="status">
			<tr>
				<td>${ status.count }</td>
				<td>${ todo.priority }</td>
				<td>${ todo.content }</td>
				<td>${ todo.date }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<span style="color: red;">${errorMsg }</span>
	<form action="UpdateServlet" method="post">
		変更No:<select name="no" id="no" onload="selectboxChange();">
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<option value="${status.index}">${ status.count }</option>
			</c:forEach>
		</select> 重要度:<select name="priority" id="priority">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select> 内容:<input type="text" name="content" id="content" size="20" value="">
		期日:<input type="date" name="date" id="date" value=""> <input
			type="submit" value="変更"><br>
	</form>
	<hr>
	<c:if test="${not empty removeErrorMsg}">
		<div class="alter alter-danger" role="alert">${removeErrorMsg}</div>
	</c:if>
	<form action="RemoveServlet" method="post">
		削除No:<select name="no">
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<option value="${status.index}">${ status.count }</option>
			</c:forEach>
		</select> <input type="submit" value="削除">
	</form>

	<hr>
	<form action="InputServlet" method="get">
		<input type="submit" value="戻る">
	</form>
	<script>
		var index = 5 - $
		{
			todo.priority
		};
		document.getElementById("priority").options[index].selected = true;
	</script>
	<script type="text/javascript">
		function selectboxChange() {
			//選択された変更Noを取得
			var row = document.getElementById("no").selectedIndex + 1;
			//TODOリストのテーブルを取得
			var table = document.getElementById('targetTable');
			//選択された変更NoからTODOリストのテーブルの行・列の値を取得し、変更情報としてinput要素のvalueに設定
			document.getElementById("priority").options[(5 - table.rows[row].cells[1].innerText)].selected = true;
			document.getElementById('content').value = table.rows[row].cells[2].innerText;
			document.getElementById('deadline').value = table.rows[row].cells[3].innerText;
		}
	</script>
</body>
</html>