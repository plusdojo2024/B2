<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家事登録</title>
<link rel="stylesheet" href="css/task_regist.css">
</head>
<body>
	<main>
		<div><!-- ボタン（画像にリンクをつける）か、リンクをボタンぽくデザインするか -->
			<!--  a href = "/B2/TaskServlet">分担一覧</a>
			<a href = "/B2/TaskServlet">登録</a>
			<a href = "/B2/TaskServlet">振り分け</a>-->
			<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="分担一覧">
			<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="登録">
			<input type="submit"   onclick="location.href='/B2/TaskServlet'"value="振り分け">
		</div>

		<div class="家事登録大枠">
 			<table>
 				<tr>
 					<td>家事名</td>
 					<td class="kajiname"><input type="text" name="task_name"></td>
 				</tr>
 				<tr>
 					<td>頻度</td>
 					<td class = "hindo"><select name="frequency">
						<option value="fir">1</option>
						<option value="sec">2</option>
						<option value="thi">3</option>
						<option value="fou">4</option>
						<option value="fif">5</option>
						<option value="six">6</option>
						<option value="sev">7</option>
						</select>
					</td>
 				</tr>
 				<tr>
 					<td>労力</td>
 					<td class="roryoku"><select name="effort">
						<option value="fir">1</option>
						<option value="sec">2</option>
						<option value="thi">3</option>
						<option value="fou">4</option>
						<option value="fif">5</option>
						</select>
					</td>
 				</tr>
 			</table>
  				<input type="submit"  value="決定">

		</div>
	</main>

</body>
</html>