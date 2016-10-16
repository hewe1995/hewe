<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/admin_index.js"></script>
<link href="css/admin_index.css" rel="stylesheet" type="text/css" />
<title>admin</title>
</head>
<body>
	<div class="top_info">
		<marquee scrollamount="2" width="300">坚持,静,静,静,静</marquee>
	</div>
	<div class="top_title">
		<div class="logo">
			<img src="images/admin_logo.png" title="hewe" />
		</div>
		<div class="title">
			<h3>HEWE</h3>
		</div>
		<div class="fr top-link">
			<a href="" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：DeathGhost</span></a>
		</div>
	</div>
	<div class="left">
		<div class="div2">用户管理</div>
		<div class="div3">
			<ul>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('admin/allUser?pageIndex=0');">查看用户</a></li>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('');">添加用户</a></li>
			</ul>
		</div>
	</div>
	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="center"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>
</body>
</html>