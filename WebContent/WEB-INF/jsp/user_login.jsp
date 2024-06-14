<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div>
			<h1>新規登録</h1>
			<form action="/B2/SignUpServlet" method="post">
			<table>
				<tr>
					<td>氏名</td>
					<td><input type="text" name="user_name"></td>
				</tr>
				 <tr>
					<td>メールアドレス</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="登録">
			</form>
		</div>
		<hr>
		<div>
			<h1>ログイン</h1>
			<form action="/B2/LoginServlet" method="post">
			<table>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" name="ログイン">
			</form>
		</div>
	</main>
	<footer>
	</footer>
</body>
</html>