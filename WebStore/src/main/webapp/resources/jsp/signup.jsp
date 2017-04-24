<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sign Up</title>
		<jsp:include page="basic.jsp"></jsp:include>
	</head>
	<body>
		<div id="signup">
			<div class="container">
				<h3>SignUp</h3>
				<form class="formValidator">
					<div class="form-group">
						<label for="userName">User Name:<input type="text" class="form-control" id="userName" placeholder="Enter your user name"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="name">Full Name:<input type="text" class="form-control" id="name" placeholder="Enter your Full name"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="email">Email:<input type="email" class="form-control" id="email" placeholder="Enter Your Email"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="bDate">Birth Date:<input type="date" class="form-control" id="bdate" placeholder="Enter Your Birth Date"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="pwd">Password:<input type="password" class="form-control" id="password" placeholder="Enter Your password"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="pwd">Confirm Password:<input type="password" class="form-control" id="cpwd" placeholder="Confirm the password"><span></</span></label>
					</div>
					<button type="submit" class="btn btn-success" value="SignUp">Submit</button>
				</form>
			</div>
		</div>
	</body>
</html>