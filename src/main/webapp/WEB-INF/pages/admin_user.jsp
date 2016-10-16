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

<link href="css/table.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
<style type="text/css">
body {
	font-size: 20px;
	padding-bottom: 40px;
	background-color: #e9e7ef;
}
</style>
</head>
<body>
	<table id="showlist">
		<tr>
			<th>用户名</th>
			<th>邮箱</th>
			<th>创建日期</th>
			<th>性别</th>
		</tr>
		<c:if test="${not empty userPage}">
			<c:forEach var="user" items="${userPage.list }" varStatus="status">
				<c:if test="${status.count%2 !='0' }">
					<tr>
						<td>${user.username }</td>
						<td>${user.email }</td>
						<td>${user.createDate }</td>
						<td>${user.sex }</td>
					</tr>
				</c:if>
				<c:if test="${status.count%2 =='0' }">
					<tr class="alt">
						<td>${user.username }</td>
						<td>${user.email }</td>
						<td>${user.createDate }</td>
						<td>${user.sex }</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>