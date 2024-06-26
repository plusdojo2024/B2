<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <main>
	<div>
	<!-- 横並び -->
	<h2>分担一覧</h2>
	<a href ="/B2/TaskServlet"></a>
	<h2>登録</h2>
	<a href ="/B2/TaskRegistServlet"></a>
	<h2>振り分け</h2>
	<a href ="/B2/TaskAutoServlet"></a>
	</div>
	<div>
		<!-- この辺大丈夫そう？ -->
		<!-- 全部ボタンの後ろにtaskautoservletのリンク貼ってある -->
		<input type="radio"  name="assign" value="autoAssignMode" />
		<label for="assignChoice1">自動</label>
		<a href ="/B2/TaskAutoServlet"></a>

		<input type="radio" name="assign" value="selfAssignMode" />
		<label for="assignChoice2">手動</label>
		<a href ="/B2/TaskSelfServlet"></a>
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
        <c:forEach var="task" items="${task_list}">
            <tr>
                <th>${task.task_name}</th>
                <c:forEach var="i" begin="0" end="6" step="1">
                    <c:set var="foundMember" value="false" />
                    <c:forEach var="member" items="${TaskAutoList}">
                        <c:if test="${member.day == i && member.task_name == task.task_name}">
                            <td>${member.user_name}</td>
                            <c:set var="foundMember" value="true" />

                        </c:if>
                    </c:forEach>
                    <c:if test="${not foundMember}">
                        <td></td>
                    </c:if>

                </c:forEach>
            </tr>
        </c:forEach>
    </table>
	</div>
	<form action = "/B2/TaskAutoServlet" method = "post">
	<button type="button">自動</button><button type="button">再振り分け</button><br>
	<input type="submit" value="決定">
	</form>
  </main>
</body>
</html>