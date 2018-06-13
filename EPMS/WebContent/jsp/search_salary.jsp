<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人事管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/HR_TABLE.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function (e) {
		$("#emp-id").val('${param.eid}');
	});
</script>
<body>
<div class="container">
       <div class="col-lg-9" id="tag">
       <div class="delete-salary-info">
                <a href="#">首页</a>
                <small>/</small>
                <a href="#">工资信息查看</a>				
        </div>
		<hr>
		<!--工资更新信息表单-->
		<div id="main" class="col-lg-12">
			<form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/SalaryMana?method=getOneInfoBySearch" method="post">
				<input type="hidden" value="${requestScope.eid}" id="hidden"/>
				<div class="form-group">
                <label for="emp-id" class="control-label col-lg-2">员工ID:</label>
                <div class="col-lg-4">
                    <select class="form-control" name="eid" id="emp-id" >
                       	<c:forEach items="${requestScope.eid }" var="i">
                       		<option >${i.employeeInfo.eid }</option>
                       	</c:forEach>
                   	</select>
                </div>
					<button type="submit" class="btn btn-default" id="submit">查询</button>
				</div>
				
				<div class="row pre-scrollable">
				<table class="table table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>员工ID</th>
                            <th>姓名</th>
                            <th>基本工资</th>
                            <th>津贴</th>
                            <th>加班费</th>
                            <th>实领工资</th>
                            <th>时间</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${vo }" var="i">
                        <tr>
                            <td>${i.personalSalary.pid }</td>
                            <td>${i.name }</td>
                            <td>${i.personalSalary.basicsalary }</td>
                            <td>${i.personalSalary.allowance }</td>
                            <td>${i.personalSalary.otsalary }</td>
                            <td>${i.personalSalary.total }</td>
                            <td>${i.personalSalary.year }年${i.personalSalary.month }月</td> 
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
			</form>
			
		</div>
    </div>
</div>
</body>
</html>

