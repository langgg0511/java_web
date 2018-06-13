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


	<%
		//获取在域对象中的工资信息
		PersonalSalary ps = (PersonalSalary) application.getAttribute("ps");
		Employee emp = (Employee) application.getAttribute("emp");
	%>

	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">个人工资查看</a>
	</div>
	<div class="col-lg-8 jumbotron salary-table-main" id="main">


		<div class="btn-group">
			<form action="/epms/SalaryInfoServlet" method="get">

查询月份： <select name="year" class="form-control"
					id="select-department">
					<option value="2017">2017年</option>
					
					</select>
				查询月份： <select name="month" class="form-control"
					id="select-department">
					<option value="1">1月</option>
					<option value="2">2月</option>
					<option value="3">3月</option>
					<option value="4">4月</option>
					<option value="5">5月</option>
					<option value="6">6月</option>
					<option value="7">7月</option>
					<option value="8">8月</option>
					<option value="9">9月</option>
					<option value="10">10月</option>
					<option value="11">11月</option>
					<option value="12">12月</option>
				</select> <input type="submit" value="查询" />
			</form>
			<table border="1px" class="table table-bordered table-condensed" id="hr_table">
				<thead>
					<tr>
						<th>职工编号</th>
						<th>姓名</th>
						<th>职位</th>
						<th>月份</th>
						<th>基本工资</th>
						<th>加班费</th>
						<th>津贴</th>
						<th>实际领取工资</th>
					</tr>
				</thead>
				<tbody>
					<%
						if ((ps != null) && (emp != null)) {
					%>
					<tr>
						<td><%=ps.getPid()%></td>
						<td><%=emp.getName()%></td>
						 <td><%=emp.getJname()%></td> 
						<td><%=ps.getMonth()%></td>
						<td><%=ps.getBasicSalary()%></td>
						<td><%=ps.getOtSalary()%></td>
						<td><%=ps.getAllowance()%></td>
						<td><%=ps.getTotal()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>




</body>
</html>