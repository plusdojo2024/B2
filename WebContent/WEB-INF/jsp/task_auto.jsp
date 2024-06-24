<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div>
		<!-- この辺大丈夫そう？ -->
		<!-- 全部ボタンの後ろにtaskautoservletのリンク貼ってある -->
		<input type="radio"  name="assign" value="autoAssignMode" />
		<label for="assignChoice1">自動</label>
		<a href ="/B2/TaskAutoServlet"></a>

		<input type="radio" name="assign" value="selfAssignMode" />
		<label for="assignChoice2">手動</label>
		<a href ="/B2/TaskSelfServlet"></a>
	</div>
	<div>
	<table>
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
<<<<<<< HEAD
	<div> <!-- 横並び -->
		<input type="submit" value="自動">
		<input type="submit" value="再振り分け">
		<a href ="/B2/TaskAutoServlet"></a>
	</div>
	<div>
		<!-- 決定ボタン -->
		<input type="submit" value="決定">
		<a href ="/B2/TaskAutoServlet"></a>
	</div>
=======
	<button type="button">自動</button><button type="button">再振り分け</button><br>
	<input type="submit" value="決定">

>>>>>>> c03e3d34b0654ef37b39f3fc582b0c2efd5e517a
  </main>
</body>
</html>