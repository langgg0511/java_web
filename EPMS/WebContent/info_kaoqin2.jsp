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
		<a href="#">首页</a> / <a href="#">查询出勤信息</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="/epms/AttanInfoServlet" method="post"
			class="form-horizontal" role="form">
		
			<div class="form-group">
				<label for="password" class="control-label col-lg-2">年份:</label>
				<div class="col-lg-4">
					<select name="year">
					 	<option value="2017">2017</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">月份:</label>
				<div class="col-lg-4">
					
					<select name="month">
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
					</select>
					
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" value="确定" class="btn btn-default" id="submit" />
				</div>
			</div>
		</form>
	</div>





</body>
</html>