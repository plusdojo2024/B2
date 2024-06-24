<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>やることリスト</h1>
	<div>
		<h2>個人</h2>
		<div>
			<h3>家事</h3><br>
			<input type="checkbox" name="">洗濯
		</div>
		<div>
			<h3>在庫チェック</h3><br>
			<input type="checkbox" name="">洗剤
		</div>
		<input type="submit" value="更新">
	</div>
	<div>
		<h2>全体</h2>
		<div>
			<h3>家事</h3><br>
			<input type="checkbox" name="">高橋：洗濯
		</div>
		<div>
			<h3>在庫チェック</h3><br>
			<input type="checkbox" name="">高橋：洗剤
		</div>
	</div>
</body>
</html>