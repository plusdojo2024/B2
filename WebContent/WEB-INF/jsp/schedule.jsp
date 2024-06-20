<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ include file = "header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORESE | カレンダー</title>
</head>

<body>
	<main>
		<%= request.getAttribute("calender") %>
		<div>
		<form action="/B2/SchaduleServlet" method="get">
		<select>
		<% int year = Integer.parseInt(request.getAttribute("year").toString());
   			 int month = Integer.parseInt(request.getAttribute("month").toString());
    			for(int i = year-10; i <= year+10; i++){ %>
		<option value="<%=i %>"
		<% if(i == year){ %>
			selected
		<% } %>
		><%=i %>年</option>
		<% } %>
		</select>

		<select>
		<% for(int i = 1; i <= 12; i++){ %>
		<option value="<%=i %>"
		<% if(i == month){ %>
		selected
		<% } %>
		><%=i %>月</option>
		<% } %>
		</select>
			<br/>
			<br/>
			<input type="submit" id="ok" name="ok" value="送信"/>
		</form>
		</div>
	</main>
</body>
</html>

		<!--<div>
			  <h1>カレンダー</h1>
			<form method="post" action="/B2/SchaduleServlet">
				<table>
					<tr>
						<th>日</th>
						<th>月</th>
						<th>火</th>
						<th>水</th>
						<th>木</th>
						<th>金</th>
						<th>土</th>
					</tr>
				</table>
			</form>
		</div>-->
