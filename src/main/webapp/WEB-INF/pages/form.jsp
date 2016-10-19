<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
</head>
<body>
	<form:form action="test/form" commandName="person" method="post">
		<form:input path="name" /><form:errors path="name"></form:errors>
		<form:input path="age" />
		<input type="date" name="birth"/><form:errors path="birth"></form:errors>
		<input type="submit" value="sub" />
	</form:form>
</body>
</html>