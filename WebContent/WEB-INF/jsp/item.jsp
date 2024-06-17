<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORESE | 消耗品登録/消耗品在庫一覧</title>
</head>
<body>
	<main>
		<div>
			<div>
				<h1>消耗品登録</h1>
				<form action = "/B2/ItemServlet" method = "post"></form>
				<table>
					<tr>
						<td>品目名</td>
						<td><input type = "text" name = "item_name"></td>
					</tr>
					<tr>
						<td>家事関連名</td>
						<td><input type = "text" name = "task_name"></td>
					</tr>
					</table>
					<input type = "submit" value = "追加">
			</div>

			<div>
				<h1>消耗品在庫一覧</h1>
				<form action = "/B2/ItemServlet" method = "post"></form>
					<table>
						<tr>
							<td><input type = "checkbox" name = "item_choice" value = "chacked"></td>
							<td>品目名</td>
							<td><input type = "text" name = "item_name"></td>
						</tr>
					</table>
					<input type = "button" value = "更新">
					<input type = "button" value = "削除">
			</div>
		</div>
	</main>
</body>
</html>