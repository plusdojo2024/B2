<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/task_self.css">
</head>
<body>

  <main>
	<div>
	<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="分担一覧">
	<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="登録">
	<input type="submit"   onclick="location.href='/B2/TaskServlet'"value="振り分け">
	</div>
	<div class="radiobuttun">
		<input type="radio" > <!--  name="contact" value="email" /-->
		<label id="radiobuttun" for="contactChoice1">自動</label>

		<input type="radio" ><!--  name="contact" value="phone" /-->
		<label id="radiobuttun"for="contactChoice2">手動</label>
	</div>

	<div>
	<table>
		<tr>
			<th>&nbsp;</th>
			<th>月</th>
			<th>火</th>
			<th>水</th>
			<th>木</th>
			<th>金</th>
			<th>土</th>
			<th>日</th>
		</tr>

		<tr>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
			<td><button type="button">⊕</button></td>
		</tr>
	</table>
	</div>
	<input type="submit" value="決定">

  </main>
</body>

</html>