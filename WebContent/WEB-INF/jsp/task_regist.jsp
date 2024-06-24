<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家事登録</title>
<link rel="stylesheet" href="css/task_regist.css">
</head>
<body>
	<main>
		<div><!-- ボタン（画像にリンクをつける）か、リンクをボタンぽくデザインするか -->
			<a href = "/B2/TaskServlet">分担一覧</a>
			<a href = "/B2/TaskServlet">登録</a>
			<a href = "/B2/TaskServlet">振り分け</a>
			<input type="submit"  value="分担一覧">
			<input type="submit"  value="登録">
			<input type="submit"  value="振り分け">
		</div>

		<div>
			<form action = "/B2/TaskRegistServlet" method = "post">
 			<table>
 				<tr>
 					<td>家事名</td>
 					<td><input type="text" name="task_name"></td>
 				</tr>
 				<tr>
 					<td>詳細</td>
 					<td><input type="text" name="description"></td>
 				</tr>
 				<tr>
 					<td>頻度</td>
 					<td class = "hindo">
 						<select name="frequency">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						</select>
					</td>
 				</tr>
 				<tr>
 					<td>労力</td>
 					<td><select name="effort">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						</select>
					</td>
 				</tr>
 			</table>
  				<input type="submit"  value="決定">
  				</form>

		</div>
	</main>

</body>
</html>