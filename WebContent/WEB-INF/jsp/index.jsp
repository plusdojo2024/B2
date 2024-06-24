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
	<div>
		<p>USER ID: ${Users.ID}</p>
		<p>HOUSE ID: ${Houses.house_hash}</p>
	</div>
	<main>
		<div class="upmain">
			<div class="upmain2">
				<div>
					<img class="task_management" src="img/task.png"><br>
					<p class="upmain2name">家事管理</p>
					<a href="/B2/TaskServlet"></a>
				</div>
				<div>
					<img class="expense_management" src="img/expense.png"><br>
					<p class="upmain2name">支出管理</p>
					<a href="/B2/SettlementServlet"></a>
				</div>
				<div>
					<img class="item_management" src="img/item.png"><br>
					<p class="upmain2name">消耗品管理</p>
					<a href="/B2/ItemServlet"></a>
				</div>
			</div>
			<div class="calender">
				<p>カレンダー</p>
				<a href="/B2/ScheduleServlet"></a>
			</div>
			<div class="board">
				<p>掲示板</p>
				<a href="/B2/BoardServlet"></a>
			</div>
		</div>
		<div class="centermain">
			<div class="member">
				<p id="member">メンバー</p><br>
				<c:forEach var="e" items="${user_list}" >
				<ul>
					<li>${e.user_name}</li>
				</ul>
				</c:forEach>
			</div>
			<div class="item">
				<p class="centername">消耗品在庫一覧</p><br>
				<a href="/B2/ItemServlet"></a>
			</div>
			<div class="todo_list">
				<p class="centername">やることリスト</p><br>
				<a href="/B2/TodoServlet"></a>
			</div>
		</div>
		<div class="downmain">
			<div class="all_expense">
				<p class="downname">全体の支出</p><br>
				<a href="/B2/ExpenseServlet"></a>
			</div>
			<div class="event">
				<p class="downname">今日のイベント</p><br>
				<a href="/B2/ScheduleServlet"></a>
			</div>
		</div>
	</main>

</body>
</html>