<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码输入错误</title>
</head>
<body>
	<%
		String info=(String)application.getAttribute("info");	
	%>
	${info }
	<%
		response.setHeader("refresh", "3;/epms/info_updatePassword.jsp");
	%>
	<br/>
	<a href="/epms/info_updatePassword.jsp">返回</a>
	
</body>
</html>