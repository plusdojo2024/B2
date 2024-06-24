<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>title</title>
	<link rel="stylesheet" href="css/Index.css">
</head>

<body>
	<main>
		<div class="upmain">
			<div class="upmain2">
				<div class="家事管理">
					<img src="img/task.png"><br>
					<p>家事管理</p>
					<a href="/B2/TaskServlet"></a>
				</div>
				<div class="支出管理">
					<img src="img/expense.png"><br>
					<p>支出管理</p>
					<a href="/B2/SettlementServlet"></a>
				</div>
				<div class="消耗品管理">
					<img src="img/item.png"><br>
					<p>消耗品管理</p>
					<a href="/B2/ItemServlet"></a>
				</div>
			</div>
			<div class="カレンダー">
				<p>カレンダー</p>
				<a href="/B2/ScheduleServlet"></a>
			</div>
			<div class="掲示板">
				<p>掲示板</p>
				<a href="/B2/BoardServlet"></a>
			</div>
		</div>
		<div class="centermain">
			<div class="メンバー">
				<p>メンバー</p><br>
				<c:forEach var="e" items="${user_list}" >
				<ul>
					<li>${e.user_name}</li>
				</ul>
				</c:forEach>
			</div>
			<div class="消耗品在庫一覧">
				<p>消耗品在庫一覧</p><br>
				<a href="/B2/ItemServlet"></a>
			</div>
			<div class="やることリスト">
				<p>やることリスト</p><br>
				<a href="/B2/TodoServlet"></a>
			</div>
		</div>
		<div class="downmain">
			<div class="全体の支出">
				<p>全体の支出</p><br>
				<a href="/B2/ExpenseServlet"></a>
			</div>
			<div class="今日のイベント">
				<p>今日のイベント</p><br>
				<a href="/B2/ScheduleServlet"></a>
			</div>
		</div>
	</main>
	<footer>

	</footer>
</body>
</html>