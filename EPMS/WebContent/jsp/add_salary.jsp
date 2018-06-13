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
	$("#submit").click(function(){
		if($("#time").val()&&$("#base-salary-id").val()&&$("#attend-salary-id").val()&&$("#extra-salary-id").val()!=null){
			var message=confirm("确定要添加吗？");
	    	if(message==true){
	    		alert("添加成功！");
	    	}else{
	    		alert("取消添加");
	    		e.preventDefault();
	    	}
		}
		
	})
});
</script>
<body>
<div class="container">
      <div class="col-lg-9" id="tag">
        <div class="add-salary-info">
            <a href="#">首页</a>
            <small>/</small>
            <a href="#">工资信息添加</a>
        </div>
        <hr>
        <!--工资添加信息表单-->
        <div id="main" class="col-lg-9">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/SalaryMana?method=addSalary" method="post">
                <div class="form-group">
                    <label for="emp-id" class="control-label col-lg-2">员工ID:</label>
                    <div class="col-lg-4">
                        <select class="form-control" name="eid" id="emp-id">
                        	<c:forEach items="${requestScope.list }" var="i">
                        		<option>${i.employeeInfo.eid }</option>
                        	</c:forEach>
                   		 </select>
                    </div>
                    <div>
                    	<font color="red">${message }</font>
                    </div>
                </div>

                <div class="form-group">
                    <label for="time" class="control-label col-lg-2">时间:</label>
                    <div class="col-lg-4">
                        <input class="form-control" name="time" id="time" type="month" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="base-salary-id" class="control-label col-lg-2">基本工资:</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="base-salary-id" name="basicsalary" placeholder="请输入基本工资" type="text" required>
                    </div>
                </div>


                <div class="form-group">
                    <label for="attend-salary-id" class="control-label col-lg-2">津贴:</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="attend-salary-id" name="allowance" placeholder="请输入津贴" type="text" required>
                    </div>
                </div>

                <div class="form-group">
                    <label for="extra-salary-id" class="control-label col-lg-2">加班费:</label>
                    <div class="col-lg-4">
                        <input class="form-control" id="extra-salary-id" name="otsalary" placeholder="请输入加班费" type="text" required>
                    </div>
                </div>

                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="submit">添加</button>
                </div>
            </form>


        </div>
    </div>
</div>
</body>
</html>

