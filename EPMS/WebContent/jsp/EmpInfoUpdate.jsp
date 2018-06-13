<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="common.jsp" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function (e) {
	$("#submit").click(function(){
			var message=confirm("确定要修改吗？");
	    	if(message==true){
	    		alert("修改成功！");
	    	}else{
	    		alert("取消修改");
	    		e.preventDefault();
	    	}
	})
});
</script>
</head>
<body>
	<div class="col-lg-8" id="tag">
		<a href="#">首页</a> / <a href="#">修改员工信息</a>
	</div>
	<div class="col-lg-8" id="main">
		<form action="${pageContext.request.contextPath }/empInfoMana?method=updateEmployeeInfo" method="post"
			class="form-horizontal" role="form">
			<div class="form-group">
				<label for="old-password" class="control-label col-lg-2">员工号:</label>
				<div class="col-lg-4">
					<input type="text" name="eid" class="form-control" value="${vo.employeeInfo.eid }"
						id="old-password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="control-label col-lg-2">姓名:</label>
				<div class="col-lg-4">
					<input name="name" type="text" class="form-control" value="${vo.employeeInfo.name }"
						id="password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">年龄:</label>
				<div class="col-lg-4">
					<input type="text" name="age" class="form-control" value="${vo.employeeInfo.age }"
						id="password-again" required>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">性别:</label>
				<div class="col-lg-4">
					<select name="sex" class="form-control" id="password-again">
					<c:choose>
						<c:when  test="${vo.employeeInfo.sex=='男' }">
							<option value="男" selected>男</option>
							<option value="女">女</option>
						</c:when>
						<c:when  test="${vo.employeeInfo.sex=='女' }">
							<option value="男">男</option>
							<option value="女" selected>女</option>
						</c:when>
						<c:otherwise>
							<option value="男">男</option>
							<option value="女">女</option>
						</c:otherwise>
					</c:choose>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">部门:</label>
				<div class="col-lg-4">
					<select name="dname" class="form-control" id="password-again">
						<c:forEach items="${departList }" var="i">
							<option>${i.dname }</option>
						</c:forEach>
					</select>

				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">职位:</label>
				<div class="col-lg-4">
					<select name="jname" class="form-control" id="password-again">
						<c:forEach items="${jobList }" var="i">
							<option>${i.jname }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="password-again" class="control-label col-lg-2">工作时间:</label>
				<div class="col-lg-4">
					<input type="text" name="time" class="form-control" value="${vo.employeeInfo.time }"
						id="password-again" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" value="修改" class="btn btn-default" id="submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>