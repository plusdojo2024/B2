<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <main>
	<div>
	<h2>分担一覧</h2><h2>登録</h2><h2>振り分け</h2><!-- 横並び -->
	</div>
	<div>
		<input type="radio"  name="contact" value="email" />
		<label for="contactChoice1">自動</label>

		<input type="radio" name="contact" value="phone" />
		<label for="contactChoice2">手動</label>
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
			<td>名前</td>
		</tr>
	</table>
	</div>
	<input type="submit" value="決定">

  </main>
</body>

</html>