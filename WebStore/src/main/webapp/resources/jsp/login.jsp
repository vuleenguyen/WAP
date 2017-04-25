<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
		<jsp:include page="basic.jsp"></jsp:include>
	</head>
	<body>
		<div id="login">
			<div class="container">
				<form action="login.do" method="post">
					<div class="form-group">
						<label for="username">Username:</label> <input type="text"
							class="form-control" id="username" placeholder="Enter email" name="username" value="${cookie.username.value}"  required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" placeholder="Enter password" name="password" required>
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
					<div class="checkbox">
						<label><input type="checkbox" name="rememberMeChk" 
						<c:if test="${not empty cookie.username.value}">checked</c:if>
						/>Keep me signed in</label>
					</div>
					<div class="divider-break">
						<p>New to shop?</p>
						<a href="signup" class="btn btn-primary">Sign Up</a>
					</div>
				</form>
				<c:if test="${not empty error}">
					<p class="error">${error}</p>
				</c:if>
			</div>
		</div>
	</body>
</html>