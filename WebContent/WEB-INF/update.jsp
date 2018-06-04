<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="todo.utils.HtmlUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" flush="true" />

		<form class="form-horizontal" action="update.html?id=${param.id != null? param.id : todolist.id}" method="post">

			更新フォーム
			<hr>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">題名</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="題名" value="${param.title != null? param.title : todolist.title}">
				</div>
			</div>

			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">詳細 </label>
				<div class="col-sm-10">
					<textarea class="form-control" id="content" name= "content" placeholder="詳細">${param.content != null? param.title : todolist.content}</textarea>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">重要度 </label>
				<div class="col-sm-10">
					<div class="radio">
						<label>
							<input type="radio"  name="level" value="★★★" ${HtmlUtils.checkLevel(param.level != null? param.level : todolist.level, "★★★") }>★★★<br>
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio"   name="level" value="★★" ${HtmlUtils.checkLevel(param.level != null? param.level : todolist.level, "★★") }>★★<br>
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio"   name="level" value="★" ${HtmlUtils.checkLevel(param.level != null? param.level : todolist.level, "★") }>★
						</label>
					</div>
				</div><!-- col-sm-10 -->

			</div><!-- formgroup -->

			<div class="form-group">
				<label for="deadline" class="col-sm-2 control-label">期限</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="deadline" id="deadline" placeholder="期限" value="${param.deadline != null? param.deadline : HtmlUtils.formatDeadline(todolist)}" >
				</div>
			</div>

			<div class="row">
				<div class="col-sm-offset-2">
					<a href="index.html" class="btn btn-default"><span class="" aria-hidden="true">キャンセル</span></a>
					<button type="submit" class="btn btn-primary"><span class="" aria-hidden="true">更新</span></button>
					<a href="delete.html?id=${todolist.id}" class="btn btn-danger pull-right"><span class="" aria-hidden="true">削除</span></a>
				</div>
			</div>

		</form>

<jsp:include page="footer.jsp" flush="true" />