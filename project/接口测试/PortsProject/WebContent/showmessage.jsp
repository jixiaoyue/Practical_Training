<%@page import="Usecase.service.CaseServiceImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html" charset="utf-8"> -->
<title>批量运行</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='./css/aqua.min.css'>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div class="container flex flex-wrap justify-between">
		<div
			class="dark-mode mx-8 my-4 h-full bg-primary flex flex-col justify-between px-6 py-12 rounded overflow-hidden">

			<ul class="menu mt-6">
				<li class="menu-item"><a href="./resInfo.jsp"> <img
						src="./img/zhuye.png" class="icon fas mr-5"> 测试接口
				</a></li>

				<li class="menu-item "><a href="list"> <img
						src="./img/shujuku.png" class="icon fas mr-5"> 数据库用例
				</a></li>

				<li class="menu-item  active"><a href="MessageList"> <img
						src="./img/shujuku.png" class="icon fas mr-5"> 批量运行
				</a></li>
				<li class="divider"></li>
				<li class="menu-item"><a href=""> <img
						src="./img/shezhi.png" class="icon fas mr-5"> 设置
				</a></li>
				<li class="menu-item"><a href="./login.jsp"> <img
						src="./img/exit.png" class="icon fas mr-5"> 退出
				</a></li>
			</ul>

		</div>
	</div>

	<div class="right">

		<div class="usecase-table">
			<h3>Message Show</h3>

			<table border="1px" cellspacing="0">
				<tr>
					<th class="colR_id">ID</th>
					<th class="col_State">STATE</th>
					<th class="col_inform">IMFORMATIONS</th>

				</tr>
				<c:forEach items="${messages}" var="message">
					<tr>
						<td align="center">${message.r_id}</td>
						<td align="center">${message.state}</td>
						<td align="center">${message.information}</td>

					</tr>
				</c:forEach>

			</table>









		</div>
	</div>
	<script src="./js/script.js"></script>
</body>
</html>