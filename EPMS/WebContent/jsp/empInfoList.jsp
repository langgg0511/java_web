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
    $(function () { $('#collapse-info').collapse('hide')});
     $(function () { $('#collapse-table').collapse('show')});

</script>
<body>
<div class="container">
        
        <div class="col-lg-8" id="tag">
            <div class="hr-table-path">
                <a href="#">首页</a>
                <small>/</small>
                <a href="#">人事信息查看</a>
            </div>
            <hr>
            <div class="jumbotron hr-table-main col-lg-12">
                <table class="table table-bordered table-condensed">
                    <thead>
                        <tr>
                            <th>职工编号</th>
                            <th>姓名</th>
                            <th>年龄</th>
                            <th>性别</th>
                            <th>所属部门</th>
                            <th>岗位状态</th>
                            <th>工作时间</th>
                        </tr>
                    </thead>
                    <tbody>
                        	<c:forEach items="${requestScope.list }" var="i">
                        		<tr>
                        		<td>${i.employeeInfo.eid }</td>
                        		<td>${i.employeeInfo.name }</td>
                        		<td>${i.employeeInfo.age }</td>
                        		<td>${i.employeeInfo.sex }</td>
                        		<td>${i.department.dname }</td>
                        		<td>${i.job.jname }</td>
                        		<td>${i.employeeInfo.time }年</td>
                        		</tr>
                       		 </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
</div>
</body>
</html>

