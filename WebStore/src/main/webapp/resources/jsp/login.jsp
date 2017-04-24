<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<jsp:include page="basic.jsp"></jsp:include>
	</head>
	<body>
		<div id="login">
			<div class="container">
				<form class="formValidator">
					<div class="form-group">
						<label for="email">Username: <input type="email" class="form-control" id="userNameR" placeholder="Enter email"><span></span></label>
					</div>
					<div class="form-group">
						<label for="pwd">Password:<input type="password" class="form-control" id="pwd" placeholder="Enter password"><span></span></label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
			</div>
		</div>
	</body>
</html>