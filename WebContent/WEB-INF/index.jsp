<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="todo.utils.HtmlUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" flush="true" />

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

<jsp:include page="footer.jsp" flush="true" />