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
<body>
<div class="container">
      <div class="col-lg-8" id="tag">
        <a href="#">首页</a>
        /
        <a href="#">数据管理</a>
    </div>
    <div class="col-lg-8" id="main">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="backup">数据库备份</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="return">数据库还原</button>
                    <p>（还原数据库前请确保当前数据库已备份，以防止数据库出错）</p>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

