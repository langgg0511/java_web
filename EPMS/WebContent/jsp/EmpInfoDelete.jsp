<%@page import="b_empInfoMana.entity.Job"%>
<%@page import="b_empInfoMana.entity.Department"%>
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

	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">删除员工</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/EmpDeleteServlet" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label for="old-password" class="control-label col-lg-2">员工号:</label>
				<div class="col-lg-4">
					<input type="text" name="eid" class="form-control"
						id="old-password" required>
				</div>
			</div>
			
		
			
		
			
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" value="删除" class="btn btn-default" id="submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>