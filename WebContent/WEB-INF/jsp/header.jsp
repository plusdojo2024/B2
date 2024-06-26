<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/script.js"></script>
</head>

<body>
	<header class = "header">
		<div class = "title">
			<a href = "/B2/IndexServlet">
			<h1>FORESE</h1>
			</a>
		</div>
		<div class = "three">
		<div class = "notification">
			<a>
			<img src = "/B2/img/notification.png" height = "20px" width = "20px">
			</a>
		</div>

		<div class = "todo">
			<a>
			<img>
			</a>
		</div>

		<div class = hamburger>
			<!-- ハンバーガーメニューを出したり消したりするチェックボックス -->
			<input type = "checkbox" id = "check">
			<label for="check"><span></span></label>
			<nav>
				<ul>
					<li>家事管理
					<li><a href = "/B2/TaskServlet">分担一覧</a>
					<li><a href = "/B2/TaskRegistServlet">登録</a>
					<li><a href = "/B2/TaskAutoServlet">振り分け</a>
					<li>支出管理
					<li><a href = "/B2/ReceiptServlet">レシート登録/精算</a>
					<li><a href = "/B2/SettlementServlet">支出一覧</a>
					<li><a href = "/B2/ItemRegistServlet">在庫管理（在庫登録/在庫一覧）</a>
					<li><a href = "/B2/ScheduleServlet">カレンダー</a>
					<li><a href = "/B2/TodoServlet">やることリスト</a>
					<li><a href = "/B2/MyInfoServlet">プロフィール</a>
					<li><a href = "/B2/LogoutServlet">ログアウト</a>
				</ul>
			</nav>
		</div>
		</div>
	</header>

	<footer class = "footer">
	</footer>
</body>
</html>