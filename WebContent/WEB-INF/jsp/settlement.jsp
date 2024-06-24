<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div>
			<!-- レシート登録画面の表示 -->
			<h1>レシート登録</h1>
			<a href="/B2/ExpenseServlet">支出一覧</a>
			<form action="/B2/ReceiptServlet" method="post">
				<table>
					<tr>
						<td>レシート名</td>
						<td><input type="text" name="receipt_name"></td>
					</tr>
					<tr>
						<td>金額</td>
						<td><input type="text" name="receipt_amount"></td>
					</tr>
					<tr>
						<td>詳細</td>
						<td><input type="text" name="詳細"></td>
					</tr>
				</table>
				<input type="checkbox" value="fix_cost">固定費 <input
					type="submit" value="登録">
			</form>
		</div>
		<hr>
		<div>
			<!-- 精算画面の表示 -->
			<%-- 			<c:forEach var="e" items="${receiptList }">
			<h1>精算</h1>
			<form action="/B2/SettlementServlet" method="post">
				<table>			<!-- ここ修正するかも（table必要なのか？） -->
					<tr>
						<td><p>${e.receipt_amount }</p></td>
						<td><p>${e.description }</p></td>
						<td><p>${e.expense_date }</p></td>
						<td><p>
						<c:if test="${e.settlement_finish  == false}">
						未精算
						</c:if>

						</p></td>
						<td><p>${e.settlement_approval }</p></td>
						<td><p>${e.settlement_date }</p></td>
						<td><input type="submit" value="精算"></td>
					</tr>
				</table>

			</form>


			</c:forEach> --%>
			<h1>精算</h1>
			<form action="/B2/SettlementServlet" method="post">
				<c:forEach var="e" items="${receiptList }">

					<table>
						<!-- ここ修正するかも（table必要なのか？） -->
						<tr>
							<td><p>${e.receipt_name }</p></td>
							<td><p>${e.receipt_amount }円</p></td>
							<td><p>${e.expense_date }</p></td>
							<td><p>
							<c:if test="${e.settlement_finish  == false}">
							未精算
							</c:if>
							<c:if test="${e.settlement_finish  == true}">
							精算済み
							</c:if>
							</p></td>
							<td><p>${e.settlement_date }</p></td>
							<td><input type="submit" value="精算"><input type="submit" value="削除"></td>
						</tr>
					</table>
				</c:forEach>
				<input type="submit" name="all" value="まとめて精算">
			</form>
		</div>
	</main>
</body>
</html>