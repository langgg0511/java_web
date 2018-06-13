<%@page import="epms.b_empInfoMana.entity.Employee"%>
<%@page import="epms.a_personalInfoMana.entity.PersonalSalary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
	<%
		//获取域对象中的员工信息list数据
		List<Employee> list = (List<Employee>) application.getAttribute("list");
		
	%>



	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">个人工资查看</a>
	</div>
	<div class="col-lg-8 jumbotron salary-table-main" id="main">


		<table border="1px" id="personal-info" width="90%" align="center">
			<tbody>
				<tr>
					<td align="center">员工号</td>
					<td align="center">姓名</td>

					<td align="center">年龄</td>

					<td align="center">性别</td>
					<td align="center">部门</td>
					<td align="center">岗位</td>
					<td align="center">入职时间</td>
				</tr>
				
					<%
						for(int i=0;i<list.size();i++){
							Employee employee=list.get(i);
					%>
					<tr>
					<td align="center"><%=employee.getEid() %></td>
					<td align="center"><%=employee.getName() %></td>

					<td align="center"><%=employee.getAge() %></td>

					<td align="center"><%=employee.getSex() %></td>
					<td align="center"><%=employee.getDname() %></td>
					<td align="center"><%=employee.getJname() %></td>
					<td align="center"><%=employee.getTime() %></td>
					</tr>
					<% 
					
						}
					%>
					
				

			</tbody>
		</table>
	</div>




</body>
</html>