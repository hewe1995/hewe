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
<script type="text/javascript" src="js/index.js"></script>
<link href="css/table.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<table id="showlist">
		<tr>
			<th>文件名</th>
			<th>上传用户</th>
			<th>下载次数</th>
			<th>上传日期</th>
		</tr>
		<c:if test="${not empty filePage}">
			<c:forEach var="file" items="${filePage.list }" varStatus="status">
				<c:if test="${status.count%2 !='0' }">
					<tr>
						<td><a href="file/download?id=${file.id }">${file.name }</a></td>
						<td>${file.user.username }</td>
						<td>${file.downtimes }</td>
						<td>${file.upTime }</td>
					</tr>
				</c:if>
				<c:if test="${status.count%2 =='0' }">
					<tr class="alt">
						<td><a href="file/download?id=${file.id }">${file.name }</a></td>
						<td>${file.user.username }</td>
						<td>${file.downtimes }</td>
						<td>${file.upTime }</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
	</table>
	<div
		style="position: fixed; bottom: 14px; right: 10%; left: 10%; text-align: center;">
		<c:if test="${not empty filePage }">
		   当前第[${filePage.currentPageNum }]页 &nbsp; &nbsp;
    
    <c:forEach var="pagenum" begin="${filePage.startPage}"
				end="${filePage.endPage}">
    	[<a href="client/showFile?pageIndex=${pagenum }">${pagenum }</a>]
    </c:forEach>
    &nbsp; &nbsp;
    总共[${filePage.totalPage }]页，总[${filePage.totalRecord }]纪录
    <c:if test="${filePage.currentPageNum > 1 }">
				<input type="submit" value="上一页"
					onclick="openurl('client/showFile?pageIndex=${filePage.currentPageNum - 1}');" />
			</c:if>
			<c:if test="${filePage.currentPageNum < filePage.endPage }">
				<input type="submit" value="下一页"
					onclick="openurl('client/showFile?pageIndex=${filePage.currentPageNum + 1}');" />
			</c:if>
		</c:if>
	</div>
</body>
</html>