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
	$(document).ready(function (e) {
    	$("#submit").click(function(){
    		var message=confirm("确定要修改权限吗？");
        	if(message==true){
        		alert("修改成功！");
        	}else{
        		alert("取消修改");
        		e.preventDefault();
        	}
    	})
    });

</script>

<body>
<div class="container">
      <div class="col-lg-8" id="tag">
        <a href="#">首页</a>
        /
        <a href="#">用户权限管理</a>
    </div>
    <div class="col-lg-8" id="main">
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SysMana?method=authority" method="post"> 
            <div class="form-group">
                <label class="control-label col-lg-2">选择部门和岗位</label>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="select-department">部门:</label>
                <div class="col-lg-4">
                    <select class="form-control" name="department" id="select-department">
                        <option value="1">人事部</option>
                        <option value="2">财务部</option>
                        <option value="3">技术部</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="select-post">岗位:</label>
                <div class="col-lg-4">
                    <select class="form-control" name="job" id="select-post">
                        <option value="1">总经理</option>
                        <option value="2">总监</option>
                        <option value="3">普通员工</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2">选择权限</label>
            </div>
            <div class="form-group">
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="add_person" id="add-employee">人事信息添加
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="delete_person" id="delete-employee">人事信息删除
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="update_person" id="update-employee">人事信息更新
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="view_person" id="check-employee">人事信息查看
                </label>
            </div>
            <div class="form-group">
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="view_attendance" id="check-kaoqin">查看考勤状况
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="update_attendance" id="update-kaoqin">人事信息更新
                </label>
            </div>
            <div class="form-group">
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="add_delete_salary" id="add-salary">工资信息添加与删除
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="update_salary" id="update-salary">工资信息更新
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="view_salary" id="check-salary">工资信息查看
                </label>
            </div>
            <div class="form-group">
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="person_management" id="employee-table">人事信息报表管理
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="salary_management" id="salary-table">工资信息报表管理
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="attendance_managemen" id="kaoqin-table">考勤信息报表管理
                </label>
            </div>
            <div class="form-group">
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="authority_management" id="user-permission">用户权限管理
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="add_account" id="add-account">添加账户
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="logout_account" id="delete-account">注销账户
                </label>
                <label class="checkbox-inline col-lg-offset-1">
                    <input type="checkbox" name="authority" value="sys_preserve" id=system-maintenance">系统维护
                </label>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default" id="submit">确定</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

