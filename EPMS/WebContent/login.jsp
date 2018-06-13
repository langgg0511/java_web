<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/企业人事登录页面.css" rel="stylesheet" />
<style>
#content {
	width: 1000px;
	height: 550px;
	background-image: url(img/首页背景图2.jpg);
	background-repeat: no-repeat;
	margin: 0 auto;
}
</style>
<title>企业人事管理系统登录页面</title>
</head>
<body>
<!--顶部 页面logo-->
	<div id="header">
		<div id="inside">
			<img src="img/企业人事管理系统头部.png" alt="企业人事管理系统"/>
		</div>
	</div>
	<div id="bg">
	<div id="content" >
		
		<form name="login-form"  method="post" action="/epms/LoginServlet" id="login-form" style="display: block; height: 240px; overflow: hidden;">
		<div id="login-frame">
		
			<p class="firstp">
			<label><b>账 &nbsp; 号 :&nbsp;</b> </label><input  id="txtUser" name="number" maxlength="20" style="width:180px;height: 25px;" type="text"/>
			</p>
			<p class="secondp">
			<label><b>密 &nbsp; 码 :&nbsp;</b> </label><input id="txtPwd" name="password" maxlength="20" style="width:180px;height: 25px;"  type="password"/>
			</p>
			<div id="forget-pwd"><a href="">忘记密码？</a></div>
			<div id="loginbtn"><input name="btnLogin" value=" 登 录 " onclick="" id="btnLogin" class="button" type="submit"></div>
		</div>
		</form>
	</div>
	
	<div id="footer" >
		<div id="xiabiao">copyright2018@计科</div>
	</div>
	</div>
</body>
</html>