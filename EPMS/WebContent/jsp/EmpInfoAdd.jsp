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
<%
	//获取部门表信息
	ServiceImpl serviceImpl=new ServiceImpl();

	List<Department> deptList=(List<Department>)serviceImpl.queryDeptInfo();
	List<Job> jobList=(List<Job>)serviceImpl.queryJobInfo();

%>
	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">添加员工</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/EmpAddServlet" method="post" class="form-horizontal" role="form">
			<div class="form-group">
				<label for="old-password" class="control-label col-lg-2">员工号:</label>
				<div class="col-lg-4">
					<input type="text" name="eid" class="form-control"
						id="old-password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-lg-2">姓名:</label>
				<div class="col-lg-4">
					<input name="empName" type="text" class="form-control"
						id="password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">年龄:</label>
				<div class="col-lg-4">
					<input type="text" name="age" class="form-control"
						id="password-again" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">性别:</label>
				<div class="col-lg-4">
					<select name="sex" class="form-control" id="password-again">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">部门:</label>
				<div class="col-lg-4">
					<select name="deptid" class="form-control" id="password-again">
					<%
						for(int i=0;i<deptList.size();i++){
							Department dept=deptList.get(i);
					%>
					<option value=<%=dept.getId() %>><%=dept.getDname() %></option>
					<% 
						}
					%>
						
					</select>

				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">重复密码:</label>
				<div class="col-lg-4">
					<select name="jobid" class="form-control" id="password-again">
						
							<%
						for(int i=0;i<jobList.size();i++){
							Job job=jobList.get(i);
					%>
					<option value=<%=job.getId() %>><%=job.getJname() %></option>
					<% 
						}
					%>
					<!-- 	<option value="">职位一</option>
						<option value="">职位二</option>
						<option value="">职位三</option> -->
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">工作时间:</label>
				<div class="col-lg-4">
					<input type="text" name="time" class="form-control"
						id="password-again" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" value="添加" class="btn btn-default" id="submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>