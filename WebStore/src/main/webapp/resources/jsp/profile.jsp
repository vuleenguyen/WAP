<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
<jsp:include page="basic.jsp"></jsp:include>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="profile">
		<div class="main">
			<h3>My Profile</h3>

			<div class="col-sm-6 divSiprator">
				<h2>My information</h2>
				
				${successMsg}
				
				<form class="formValidator" method="post">
					<!-- <div class="form-group">
						<label for="userName">User Name:<input type="text"
							class="form-control" id="userName" name="userName"
							placeholder="Enter your user name" value="${currentUser.userName}" /><span></</span></label>
					</div> -->
					<div class="form-group">
						<label for="name">Full Name:<input type="text"
							value="${currentUser.fullName}" class="form-control" id="name" name="fName"
							placeholder="Enter your Full name" /><span></</span></label>
					</div>
					<div class="form-group">
						<label for="email">Email:<input type="email"
							value="${currentUser.email}" class="form-control" id="email" name ="email"
							placeholder="Enter Your Email" /><span></</span></label>
					</div>
					<div class="form-group">
						<label for="bDate">Birth Date:<input type="date"
							value="${currentUser.birthDate}" name="bdate" class="form-control" id="bdate"
							placeholder="Enter Your Birth Date" /><span></</span></label>
					</div>
					<div class="form-group">
						<label for="pwd">Password:<input type="password" name="password"
							value="${currentUser.passWord}" class="form-control" id="password"
							placeholder="Enter Your password"><span></</span></label>
					</div>
					<div class="form-group">
						<label for="pwd">Confirm Password:<input type="password"
							value="${currentUser.passWord}" class="form-control" id="cpwd"
							placeholder="Confirm the password"><span></</span></label>
					</div>
					<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
			<div class="col-sm-6">
				<h2>My Order History</h2>

				<div id="orderHistoryJs" class="list-group overflowAuto">
					<div
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">Order #000112</h5>
							<small>3 days ago</small>
						</div>
						<p class="mb-1">
						<div class="list-group">
							<a href="#" class="list-group-item list-group-item-action">
								item #1 </a> <a href="#"
								class="list-group-item list-group-item-action"> item #2 </a> <a
								href="#" class="list-group-item list-group-item-action">
								item #3 </a>
						</div>
					</div>
					<div
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">Order #003412</h5>
							<small>3 days ago</small>
						</div>
						<p class="mb-1">
						<div class="list-group">
							<a href="#" class="list-group-item list-group-item-action">
								item #1 </a> <a href="#"
								class="list-group-item list-group-item-action"> item #2 </a> <a
								href="#" class="list-group-item list-group-item-action">
								item #3 </a>
						</div>
					</div>
					<div
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">Order #02340112</h5>
							<small>3 days ago</small>
						</div>
						<p class="mb-1">
						<div class="list-group">
							<a href="#" class="list-group-item list-group-item-action">
								item #1 </a> <a href="#"
								class="list-group-item list-group-item-action"> item #2 </a> <a
								href="#" class="list-group-item list-group-item-action">
								item #3 </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>