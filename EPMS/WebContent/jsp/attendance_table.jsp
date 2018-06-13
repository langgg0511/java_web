<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common.jsp" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工考勤报表管理</title>	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ATTENDANCE_TABLE.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<script type="text/javascript">
    $(function () { $('#collapse-info').collapse('hide')});
    $(function () { $('#collapse-table').collapse('show')});

</script>
<body>
<div class="container">
 
    <div class="col-lg-9" id="tag">
        <div class="attendance-table-path">
            <a href="#">首页</a>
            <small>/</small>
            <a href="#">员工考勤报表管理</a>
        </div>
        <hr>
        <div class="jumbotron attendance-table-main">
      	  <form class="form-horizontal" role="form" action="${pageContext.request.contextPath }/reportMana?method=getAttendInfoByMonth" method="post">
            <span>输入查询日期：</span>
            <span>从</span><input type="month" name="startDate" id="startDate" required/>
            <span>到</span><input type="month" name="endDate" id="endDate" required/>
            <div class="btn-group">
                <input type="submit" class="btn btn-default" value="查询报表"/>
            </div>
            </form>
            <div class="btn-group margin-l">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">导出报表<span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#">导出为PDF</a></li>
                    <li><a href="#">导出为excel</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">打印</a></li>
                </ul>
            </div>
            
            <div class="row pre-scrollable">
            <table class="table table-bordered table-condensed ">
                <thead>
                <tr>
                    <th>职工编号</th>
                    <th>姓名</th>
                    <th>月份</th>
                    <th>应出勤天数</th>
                    <th>实际出勤天数</th>
                    <th>加班时长</th>
                </tr>
                </thead>
                
               	 <tbody>
                     <c:forEach items="${requestScope.list }" var="i" >
                   		<tr>
	                   		<td>${i.attendance.eid }</td>
	                   		<td>${i.name }</td>
	                   		<td>${i.attendance.year }年${i.attendance.month }月</td>
	                   		<td>${i.attendance.prin_day }</td>
	                   		<td>${i.attendance.onduty_day }</td>
	                   		<td>${i.attendance.overtime }</td>
                   		</tr>
                     </c:forEach>
                </tbody>
                
            </table>
           
               </div>
        </div>
    </div>
</div>
</body>
</html>
