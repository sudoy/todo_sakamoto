<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="todo.utils.HtmlUtils" %>

<jsp:include page="header.jsp" flush="true" />

<jsp:include page="include/success.jsp" />
<jsp:include page="include/errors.jsp" />


		<form class="form-horizontal" action="entry.html" method="post">

			登録フォーム
			<hr>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">題名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" id="title" placeholder="題名" value="${param.title}">
				</div>
			</div>

			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">詳細 </label>
				<div class="col-sm-10">
					<textarea class="form-control" name="content" id="content" placeholder="詳細">${param.content}</textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">重要度 </label>
				<div class="col-sm-10">
					<div class="radio">
						<label>
							<input type="radio"  name="level" id="level3" value="★★★" ${HtmlUtils.checkLevel(param.level, "★★★") }>★★★<br>
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio"   name="level" id="level2" value="★★" ${HtmlUtils.checkLevel(param.level, "★★") }>★★<br>
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio"   name="level" id="level1" value="★" ${HtmlUtils.checkLevel(param.level, "★") }>★
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="deadline" class="col-sm-2 control-label">期限</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="deadline" id="deadline" placeholder="期限" value="${param.deadline}">
				</div>
			</div>

			 <div class="row">
			 	<div class="col-sm-offset-2">
			 		<a href="index.html" class="btn btn-default"><span class="" aria-hidden="true">キャンセル</span></a>
			 		<button type="submit" class="btn btn-primary"><span class="" aria-hidden="true">追加</span></button>
			 	</div>
			 </div>

		</form>

<jsp:include page="footer.jsp" flush="true" />