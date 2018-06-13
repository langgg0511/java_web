<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>人事管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function () {
    	$("#delete").click(function(e){
    		if($("#user-id").val()!=$("#user-id-again").val()){
        		alert("两次输入员工证件号不一致，请重新输入");
        		e.preventDefault();
        	}
    		else{
    			alert("提交成功");
    		}
    	});
    });

</script>
<body>
<div class="container">
     <div class="col-lg-8" id="tag">
        <a href="#">首页</a>
        /
        <a href="#">删除账户</a>
    </div>
    <div class="col-lg-8" id="main">
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SysMana?method=deleteAccount" method="post">
            <div class="form-group">
                <label for="user-id" class="control-label col-lg-2">员工证件号:</label>
                <div class="col-lg-4">
                    <input type="text" name="number" class="form-control" id="user-id" placeholder="请输入员工证件号">
                </div>
                <div>
                	<font color="red">${mess }</font>
                </div>
            </div>
            <div class="form-group">
                <label for="user-id-again" class="control-label col-lg-2">确认员工证件号:</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control" id="user-id-again" placeholder="请重新输入员工证件号">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="delete">删除</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

