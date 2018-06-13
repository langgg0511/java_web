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
    	$("#submit").click(function(e){
    		if($("#password").val()!=$("#password-again").val()){
        		alert("密码不一致，请重新输入");
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
      <div class="col-lg-8" id="main">
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SysMana?method=addAccount" method="post" >
            <div class="form-group">
                <label for="user-id" class="control-label col-lg-2">员工证件号:</label>
                <div class="col-lg-4">
                    <input type="text" name="number" class="form-control" id="user-id" placeholder="请输入员工证件号">
                </div>
                <div>
                	<font color="red">${requestScope.mess }</font>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="control-label col-lg-2">密码:</label>
                <div class="col-lg-4">
                    <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" value="123456">
                </div>
            </div>
            <div class="form-group">
                <label for="password-again" class="control-label col-lg-2">重复密码:</label>
                <div class="col-lg-4">
                    <input type="password" class="form-control" id="password-again" placeholder="请重新输入密码"
                           value="123456">
                    <span>默认密码为123456</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" class="btn btn-default" id="submit" value="确定"/>
                </div>
         
        </form>
        </div>
    </div>
</div>
</body>
</html>

