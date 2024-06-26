<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/task_auto.css">
</head>
<body>

  <main>
	<div>
	<!-- 横並び -->
	<input type="submit"  onclick="location.href='/B2/TaskServlet'" value="分担一覧">
	<input type="submit"  onclick="location.href='/B2/TaskRegistServlet'" value="登録">
	<input type="submit"   onclick="location.href='/B2/TaskServlet'"value="振り分け">
	</div>
	<div>
		<!-- この辺大丈夫そう？ -->
		<!-- 全部ボタンの後ろにtaskautoservletのリンク貼ってある -->
		<input type="radio" name="radiobuttun" value="1" id="auto">自動
		<input type="radio" name="radiobuttun" value="2" id="self">手動
	</div>
	<div class="table_auto">
	<table>
		<tr class="dayname">
			<th  id="nbsp">&nbsp;</th>
			<th  id="dayname">月</th>
			<th>火</th>
			<th>水</th>
			<th>木</th>
			<th>金</th>
			<th>土</th>
			<th>日</th>
		</tr>
		<tr class="member_name">
			<td>料理</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
		</tr>
		<tr class="member_name">
			<td>風呂掃除</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
		</tr>
			<tr class="member_name">
			<td>トイレ掃除</td>
			<td>谷口せんせえ</td>
			<td>あっきー</td>
			<td>はっしー</td>
			<td>そらぴょん</td>
			<td>伊東プロ</td>
			<td>ウェルカム浅野</td>
			<td>あっきー</td>
	</table>
	</div>
<!-- <<<<<<< HEAD -->
	<div> <!-- 横並び -->
		<input type="submit" value="自動" >
		<input type="submit" value="再振り分け">
		<a href ="/B2/TaskAutoServlet"></a>
	</div>
	<div>
		<!-- 決定ボタン -->
		<input type="submit" value="決定">
		<a href ="/B2/TaskAutoServlet"></a>
	</div>

<!--  >>>>>>> c03e3d34b0654ef37b39f3fc582b0c2efd5e517a -->
  </main>
</body>
</html>