<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Todoリスト</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<link href="css/main.css" rel="stylesheet">

		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<nav class="navbar navbar-default navbar-custom">

			<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
				<a class="navbar-brand" href="index.html">Todoリスト</a>
			</div>

		</nav>

		<div class="container">
		<div class="row">
<!--
			<div class="alert alert-success" role="alert">
				<button type="button" data-dismiss="alert" class="close" ><span aria-hidden="true">&times;</span></button>
				<h4 class="alert-heading">完了しました!</h4>
				<ul>
					<li>No.27のTodoを更新しました。</li>
				</ul>
			</div>
-->
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
		</c:if>
