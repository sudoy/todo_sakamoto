<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${errors.size() > 0 }">
	<div class="alert alert-danger" role="alert">
		<button type="button" data-dismiss="alert" class="close" ><span aria-hidden="true">&times;</span></button>
	 	<h4 class="alert-heading">エラーが発生しました！</h4>
			<ul>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
			</ul>
	</div>

	<%
	session.setAttribute("errors", null);
	%>

</c:if>

