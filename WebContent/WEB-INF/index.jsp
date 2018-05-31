<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="todo_sakamoto.HtmlUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp" flush="true" />
<html>


	<body>
		<div class="container">
		<div class="row">

			<div class="alert alert-success" role="alert">
				<button type="button" data-dismiss="alert" class="close" ><span aria-hidden="true">&times;</span></button>
					<h4 class="alert-heading">完了しました!</h4>
					<ul>
						<li>No.27のTodoを更新しました。</li>
					</ul>

			</div>

			<div class="alert alert-danger" role="alert">
				<button type="button" data-dismiss="alert" class="close" ><span aria-hidden="true">&times;</span></button>
		 			<h4 class="alert-heading">エラーが発生しました！</h4>
					<ul>
						<li>題名は必須入力です。</li>
						<li>題名は100文字以内にしてください。</li>
						<li>期限は「YYYY/MM/DD」形式で入力してください。</li>
					</ul>
			</div>

		<form class="form-horizontal" action="#" method="post">

			<table class="table">

				<tr class="container">
					<td>#</td>
					<td>題名</td>
					<td>重要度</td>
					<td>期限</td>
				</tr>

			<c:forEach var="todolist" items="${list}">
				<tr class="container">
					<td>${todolist.id}</td>
					<td><a href="update.html?id=${todolist.id}">${todolist.title}</a></td>
					<td>${todolist.level}</td>
					<td>${HtmlUtils.formatDeadline(todolist)}</td>
				</tr>
			</c:forEach>

			</table>

			<div class="">
				<a href="entry.html" class="btn btn-primary"><span class="" aria-hidden="true">追加</span></a>
			</div>

		</form>

		</div>
		</div>

<jsp:include page="footer.jsp" flush="true" />