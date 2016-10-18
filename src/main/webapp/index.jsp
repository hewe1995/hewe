<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link href="css/index.css" rel="stylesheet" type="text/css" />
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
		<div style="float: right; margin-top: 40px; margin-right: 10px">
			<c:if test="${empty user }">
				<a href="login">登录</a>
			</c:if>
			<c:if test="${not empty user }">
				欢迎您:
				<span>${user.username }</span>
			</c:if>
		</div>
	</div>
	<div class="left">
		<div class="div2">文件</div>
		<div class="div3">
			<ul>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('client/showFile?pageIndex=0');">查看文件</a></li>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('file/upload');">上传文件</a></li>
			</ul>
		</div>
		<div class="div2">个人中心</div>
		<div class="div3">
			<ul>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('client/myFiles');">我的文件</a></li>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('client/myInfo');">个人信息</a></li>
				<li><a class="a" href="javascript:void(0);"
					onClick="openurl('logout');">退出</a></li>
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
