<%@page import="java.text.SimpleDateFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>
<%
	SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String strDate = st.format(date);
	pageContext.setAttribute("strDate", strDate);
%>
<title>注册</title>
</head>
<body>
	<form:form action="register" method="post"
		modelAttribute="registerForm">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="username" id="name" /></td>
				<td><form:errors path="username" /></td>
				<td id="hint"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>Sex:</td>
				<td><form:select path="sex" items="${registerForm.sexes }" /></td>
				<td><form:errors path="sex" /></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>birthday</td>
				<td><input type="date" name="birth" value="${strDate }" /></td>
				<td><form:errors path="birth"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>

		</table>

	</form:form>
</body>
</html>