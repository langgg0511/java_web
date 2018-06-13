<%@page import="a_personalInfoMana.entity.Employee"%>
<%@page import="c_attanInfoMana.entity.Attendance"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="b_empInfoMana.service.impl.ServiceImpl"%>

<%@ include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</head>
<body>

<%
	Employee employee=(Employee)application.getAttribute("employee");
%>
	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">员工个人信息</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/EmpAddServlet" method="post"
			class="form-horizontal" role="form">

			<div class="form-group">
				<label for="password" class="control-label col-lg-2">员工号:</label>
				<div class="col-lg-4"><%=employee.getEid() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">名字:</label>
				<div class="col-lg-4"><%=employee.getName() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">年龄:</label>
				<div class="col-lg-4"><%=employee.getAge()%></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">性别:</label>
				<div class="col-lg-4"><%=employee.getSex()%></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">部门名称:</label>
				<div class="col-lg-4"><%=employee.getDname() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">职位:</label>
				<div class="col-lg-4"><%=employee.getJname() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">工作时间:</label>
				<div class="col-lg-4"><%=employee.getTime() %></div>
			</div>
			

		</form>
	</div>
</body>
</html>