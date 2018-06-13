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
	Attendance attendance=(Attendance)application.getAttribute("attendance");
%>
	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">员工出勤信息</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/EmpAddServlet" method="post"
			class="form-horizontal" role="form">

			<div class="form-group">
				<label for="password" class="control-label col-lg-2">员工号:</label>
				<div class="col-lg-4"><%=attendance.getEid() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">年份:</label>
				<div class="col-lg-4"><%=attendance.getYear() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">月份:</label>
				<div class="col-lg-4"><%=attendance.getMonth() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">应到天数:</label>
				<div class="col-lg-4"><%=attendance.getPrin_day() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">实到天数:</label>
				<div class="col-lg-4"><%=attendance.getOnduty_day() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">缺勤天数:</label>
				<div class="col-lg-4"><%=attendance.getAbsenteeism() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">请假天数:</label>
				<div class="col-lg-4"><%=attendance.get_Leave() %></div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">加班天数:</label>
				<div class="col-lg-4"><%=attendance.getOvertime() %></div>
			</div>

		</form>
	</div>
</body>
</html>