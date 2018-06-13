<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<style type="text/css">
	#button{
		position: absolute;
		left:13cm;
	}
</style>
</head>
<body>

<%
    //获取用户账号
	//application.setAttribute("number", (String)request.getParameter("number"));
%>

<%
	//获取查询的数据
	 Object[] obj=new Object[13];
	if(application.getAttribute("attendance")!=null&&
			application.getAttribute("attendance")!=""){
		obj=(Object[])application.getAttribute("attendance");
	}
%>


	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">出勤情况</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/AttanInfoServlet" method="get" class="form-horizontal" role="form">
			<div class="form-group col-lg-4">
				<label class="control-label col-lg-4" for="select-department">类型:</label>
				<div class="form-inline">
					<select   name="table" class="form-control" id="select-department">
						<option value="onduty">上班</option>
						<option value="_leave">请假</option>
						<option value="overtime">加班</option>
						<option value="businesstravel">出差</option>
					</select>
				</div>
			</div>
			<div class="form-group col-lg-3">
				<label class="control-label col-lg-6" for="time">年份:</label>
				<div class="form-inline">
					<select  name="year"  class="form-control" id="time">
						<option>2018</option>
						<option>2017</option>
						<option>2016</option>
						<option>2015</option>
						<option>2014</option>
						<option>2013</option>
						<option>2012</option>
						<option>2011</option>
						<option>2010</option>
					</select>
				</div>
			</div>
			<div id="button">
				<input type="submit" value="查询" />
			</div>
			<div class="col-lg-10">
				<fieldset>
					<table class=" user-info">
						<tr>
							<td width="101" height="23">一月：</td>						
							<td width="334"><%=obj[1] %></td>
							<td width="92">二月：</td>
							<td width="335"><%=obj[2] %></td>
							<td width="92">三月：</td>
							<td width="335"><%=obj[3] %></td>
						</tr>
						<tr>
							<td width="101" height="23">四月：</td>
							<td width="334"><%=obj[4] %></td>
							<td width="92">五月：</td>
							<td width="335"><%=obj[5] %></td>
							<td width="92">六月：</td>
							<td width="335"><%=obj[6] %></td>
						</tr>
						<tr>
							<td width="101" height="23">七月：</td>
							<td width="334"><%=obj[7] %></td>
							<td width="92">八月：</td>
							<td width="335"><%=obj[8] %></td>
							<td width="92">九月：</td>
							<td width="335"><%=obj[9] %></td>
						</tr>
						<tr>
							<td width="101" height="23">十月：</td>
							<td width="334"><%=obj[10] %></td>
							<td width="92">十一月：</td>
							<td width="335"><%=obj[11] %></td>
							<td width="92">十二月：</td>
							<td width="335"><%=obj[12] %></td>
						</tr>
					</table>
				</fieldset>
			</div>
		</form>
	</div>

</body>
</html>