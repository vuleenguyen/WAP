<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<jsp:include page="basic.jsp"></jsp:include>
	</head>
	<body>
		<div id="manager">
			<a href="<c:url value='manager?action=insert'/>">Add Product</a>
		</div>
	</body>
</html>