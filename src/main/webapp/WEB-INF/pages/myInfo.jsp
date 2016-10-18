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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>Insert title here</title>
</head>
<body>
<h3><strong>基本信息：</strong><a href="client/changeInfo">(修改)</a></h3>
   <table>
               <tr>              
	              <td width="18%" height="30" align="center">用 户 名：</td>
	              <td width="82%">${user.username }</td>
	            </tr>
				<tr>              
	              <td width="18%" height="30" align="center">性别:</td>
	              <td width="82%">${user.sex }</td>
	            </tr>
	            <tr>
	              <td height="28" align="center">E-mail：</td>
	              <td height="28">${user.email }</td>
	            </tr> 
			   
	            <tr>
	              <td height="28" align="center">创建时间：</td>
	              <td height="28">${user.createDate }</td>
	            </tr> 
	        </table>
</body>
</html>