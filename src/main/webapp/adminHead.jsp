<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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

<style type="text/css">
	/*body {background-color:#b0c4de;}*/ 
	h1{text-align: center;}
	a.user {position: fixed;right: 10px;bottom: 10px}
	a.user:link {text-decoration: none;}
	a.user:hover{text-decoration: underline;}
	a.head {position: fixed;left: 10px;bottom: 10px}
	a.head:link {text-decoration: none;}
	a.head:hover{text-decoration: underline;}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>hewe</h1>
	<a class="user" href="">${user.username }</a>
	<a class="head" href="adminBody.jsp" target="adminBody">首页</a>
</body>
</html>