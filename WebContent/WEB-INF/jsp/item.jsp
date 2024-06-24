<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORESE | 消耗品登録/消耗品在庫一覧</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/item.css">
</head>
<body>
	<main>
		<div>
			<div>
				<h1>消耗品登録</h1>
				<form action = "/B2/ItemRegistServlet" method = "post">
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
				</form>
			</div>

			<hr>

			<div>
				<h1>消耗品在庫一覧</h1>
				<form action = "/B2/ItemListServlet" method = "post"></form>
				<select id = "fillter" name = "filter">
					<option value = "">絞り込み</option>
					<optgroup label = "在庫状況">
						<option value = "1">✕</option>
						<option value = "2">△</option>
						<option value = "3">◯</option>
					</optgroup>
					<optgroup label = "家事名">
						<option value = "お風呂掃除">お風呂掃除</option>
						<option value = "お皿洗い">お皿洗い</option>
						<option value = "トイレ掃除">トイレ掃除</option>
						<option value = "料理">料理</option>
					</optgroup>
				</select>
				<input type = "submit" value = "絞り込み">


					<table>
						<tr>
							<td><input type = "checkbox" name = "item_choice" value = "chacked"></td>
							<td >品目名</td>
							<td><input type = "text" name = "item_name"></td>
							<td><input type = "button" name = 3 value = ◯></td>
							<td><input type = "button" name = 2 value = △></td>
							<td><input type = "button" name = 1 value = ✕></td>
							<td></td>
						</tr>
					</table>
					<input type = "submit" value = "更新">
					<input type = "submit" value = "削除">
			</div>
		</div>
	</main>
	<footer>
	</footer>
</body>
</html>