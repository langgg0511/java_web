<%@page import="epms.a_personalInfoMana.entity.Employee"%>
<%@page import="epms.a_personalInfoMana.entity.PersonalSalary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/index.css" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

</head>
<body>


	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">密码修改</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="/epms/UpdatePasswordServlet" method="post"
			class="form-horizontal" role="form">
			<div class="form-group">
				<label for="old-password" class="control-label col-lg-2">旧密码:</label>
				<div class="col-lg-4">
					<input type="password" name="password" class="form-control"
						id="old-password" placeholder="请输入原来的密码" required>				
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-lg-2">密码:</label>
				<div class="col-lg-4">
					<input type="password" name="newPassword" class="form-control"
						id="password" placeholder="请输入新密码" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">重复密码:</label>
				<div class="col-lg-4">
					<input type="password" name="concertPassword" class="form-control"
						id="password-again" placeholder="请重新输入新密码" required>
					
				</div>
			</div>
			<input type="hidden" name="number"
				value=<%=application.getAttribute("number") %>>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" value="确定" class="btn btn-default" id="submit" />
				</div>
			</div>
		</form>
	</div>





</body>
</html>