<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Todoリスト</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" >

		<link href="css/main.css" rel="stylesheet" >

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

			<c:if test="${user ne null}">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							${user.name}
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="logout.html">ログアウト</a></li>
						</ul>
					</li>
				</ul>
			</c:if>

		</nav>

		<div class="container">
		<div class="row">
