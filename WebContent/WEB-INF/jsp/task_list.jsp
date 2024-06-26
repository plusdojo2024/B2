<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/task_auto.css">
</head>
<body>

  <main>
 	<div>
	<!-- 横並び -->
	<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="分担一覧">
	<input type="submit"  onclick="location.href='/B2/TaskRegistServlet'" value="登録">
	<input type="submit"   onclick="location.href='/B2/TaskServlet'"value="振り分け">
	</div>

	<div class="table_auto">
	<table>
		<tr class="dayname">
			<th  id="nbsp">&nbsp;</th>
			<th  id="dayname">月</th>
			<th>火</th>
			<th>水</th>
			<th>木</th>
			<th>金</th>
			<th>土</th>
			<th>日</th>
		</tr>
		<tr class="member_name">
			<td>料理</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
		</tr>
		<tr class="member_name">
			<td>風呂掃除</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
		</tr>
			<tr class="member_name">
			<td>トイレ掃除</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
	</table>
	</div>

  </main>
</body>

</html>