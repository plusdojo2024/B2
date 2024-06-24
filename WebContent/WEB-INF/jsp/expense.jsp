<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <main>

        <h1>支出一覧</h1><a>登録・精算</a><!-- ←登録・精算ボタンが押せるようにする -->
		<!-- ↓今週の支出情報と今月の支出情報は横並び -->
		<div class = "grf">
			<h2>本日</h2><br>
			<img src="本日の支出グラフ">

			<p>変動費</p><!-- 変動費は表で表示される -->
			<p>先週との差額</p>
			<p>-〇〇円</p>
			</div>
		<div class = "grf">
			<h2>今週</h2><br>
			<img src="今週の支出グラフ">

			<p>変動費</p><!-- 変動費は表で表示される -->
			<p>先週との差額</p>
			<p>-〇〇円</p>
			</div>

        <div class = "grf">
			<h2>今月</h2><br>
			<img src="今月のグラフ">

			<p>変動費</p>
			<p>先週との差額</p>
			<p>+〇〇円</p>
			</div>



  </main>

</body>
</html>