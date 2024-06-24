<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規家登録・参加</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/house_login.css">
</head>

<body>
	<main>
		<div>
 			<h1>新規家登録</h1>

 			<form method="post" action="/B2/HouseRegistServlet">
 				<table>
 					<tr>
 						<td>家の名前</td>
 						<td><input type="text" name="house_name"></td>
 					</tr>
 					<tr>
 						<td>パスワード</td>
 						<td><input type="password" name="password"></td>
 					</tr>
 				</table>
  				<input type="submit"  value="登録">
 			</form>
		</div>
		<hr>
		<div>
			<h1>家に参加</h1>

 			<form method="post" action="/B2/HouseJoinServlet">
 				<table>
 					<tr>
 						<td>ID</td>
 						<td><input type="text" name="house_hash"></td>
 					</tr>
 					<tr>
 						<td>パスワード</td>
 						<td><input type="password" name="password"></td>
 					</tr>
 				</table>
  				<input type="submit"  value="参加">
 			</form>
		</div>
	</main>
</body>
</html>