<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>人事管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>


<%
String number="xxx";
 if((application.getAttribute("number")!="")&&application.getAttribute("number")!=null){
	number=(String)application.getAttribute("number");
} 
 
 application.setAttribute("number", number);
%>

<div class="container">
    <div class="col-lg-12 head">
        <h1 class="col-xs-6">人事管理系统</h1>
        <div class="exit-user">
            <span><%=number %></span>
            <a href="#">退出</a>
           
        </div>
    </div>
    <div class="panel-group text-center" id="accordion">
        <div class="panel panel-default">
            <!--个人信息管理-->
            <!--所有用户拥有权限-->
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-user">
                        个人信息管理
                    </a>
                </h4>
            </div>
            <div id="collapse-user" class="panel-collapse collapse in">
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                        	<!-- href对应一个servlet，把需要查询的员工的员工号传送到servlet中 -->
                            <a href='/epms/PerInfoServlet?number=<%=application.getAttribute("number") %>' class="link">查看个人信息</a>
                            <a href='info_kaoqin2.jsp?number=<%=application.getAttribute("number") %>' class="link">查看考勤情况</a>
                            <a href="info_salary.jsp?number=<%=application.getAttribute("number") %>" class="link">查看工资情况</a>
                            <a href='info_updatePassword.jsp?number=<%=application.getAttribute("number") %>' class="link">修改账户密码</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--人事信息管理-->
            <!--仅人事方面人员拥有权限-->
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-info">
                        人事信息管理
                    </a>
                </h4>
            </div>
            <div id="collapse-info" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                            <a href="EmpInfoAdd.jsp" class="link">人事信息添加</a>

                            <a href="EmpInfoDelete.jsp" class="link">人事信息删除</a>

                            <a href="EmpInfoUpdate.jsp" class="link">人事信息更新</a>

                            <a href="/epms/EmpInfoServlet" class="link">人事信息查看</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--考勤管理-->
            <!--仅人事方面人员拥有权限-->
            <div class="panel-heading">
                <h4 class="panel-title nav">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-kaoqin">
                        考勤管理
                    </a>
                </h4>
            </div>
            <div id="collapse-kaoqin" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li class="link">
                            <a href="/epms/AttenInfoQuery.jsp" class="link">查看出勤状况</a>
                            <a href="/epms/AttenInfoUpdate.jsp" class="link">修改出勤状况</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--工资信息管理-->
            <!--财务方面人员，人事方面人员拥有权限-->
            <div class="panel-heading">
                <h4 class="panel-title nav">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-salary">
                        工资信息管理
                    </a>
                </h4>
            </div>
            <div id="collapse-salary" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li class="link">
                            <a href="#" class="link">工资信息添加</a>
                            <a href="#" class="link">工资信息删除</a>
                            <a href="#" class="link">工资信息更新</a>
                            <a href="#" class="link">工资信息查看</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--报表管理-->
            <!--财务方面管理员拥有（工资信息报表管理，工资信息报表管理）权限-->
            <!--人事方面管理员拥有（人力资源报表管理，工资信息报表管理）权限-->
            <div class="panel-heading">
                <h4 class="panel-title nav">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-table">
                        报表管理
                    </a>
                </h4>
            </div>
            <div id="collapse-table" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                            <a href="#" class="link">人力资源报表管理</a>
                            <a href="#" class="link">工资信息报表管理</a>
                            <a href="#" class="link">考勤报表管理</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--系统管理-->
            <div class="panel-heading">
                <h4 class="panel-title nav">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-system">
                        系统管理
                    </a>
                </h4>
            </div>
            <div id="collapse-system" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                            <a href="#" class="link">用户权限管理</a>
                            <a href="#" class="link">添加账户</a>
                            <a href="#" class="link">删除账户</a>
                            <a href="#" class="link">数据管理</a>
                            <a href="#" class="link">查看系统日志</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--系统帮助-->
            <div class="panel-heading">
                <h4 class="panel-title nav">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse-help">
                        系统帮助
                    </a>
                </h4>
            </div>
            <div id="collapse-help" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul class="nav">
                        <li>
                            <a href="#" class="link">帮助(help)</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <div class="col-lg-8" id="tag">
        <a href="#">首页</a>
    </div>
</div>
</body>
</html>
