<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <main>
	<div>
	<!-- 横並び -->
	<h2>分担一覧</h2>
	<a href ="/B2/TaskServlet"></a>
	<h2>登録</h2>
	<a href ="/B2/TaskRegistServlet"></a>
	<h2>振り分け</h2>
	<a href ="/B2/TaskAutoServlet"></a>
	</div>
	<form action = "/B2/TaskAutoServlet" method = "post">
	<div>
		<input type="radio"  name="assign" value="autoAssignMode" />
		<label for="assignChoice1">自動</label>


		<input type="radio" name="assign" value="selfAssignMode" />
		<label for="assignChoice2">手動</label>

	</div>
	<div>
		<!-- 決定ボタン -->
		<input type="submit" value="決定">

	</div>
	</form>
	<div>
	<table>
	<c:forEach var="e" items="${taskList}" >
		${e.user_name}
	</c:forEach>
		<tr>
			<th>&nbsp;</th>
			<th>月</th>
			<th>火</th>
			<th>水</th>
			<th>木</th>
			<th>金</th>
			<th>土</th>
			<th>日</th>
		</tr>
		<tr>
			<td>掃除</td>
			<td>谷口</td>
		</tr>
	</table>
	</div>
	<div> <!-- 横並び -->
		<input type="submit" value="自動">
		<input type="submit" value="再振り分け">
		<a href ="/B2/TaskAutoServlet"></a>
	</div>
  </main>
</body>
</html>