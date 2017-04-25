<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>
<jsp:include page="basic.jsp"></jsp:include>
</head>
<body>
	<div id="shoppingCart">
		<div class="orderList">
			<h1>This is list order of ${user}</h1>
			<c:forEach items="products" var="good">
				<div class="goodCheckout">
					<h3>Name</h3>
					<a><img alt="linj" src="<c:url value="productLink"/>"></a>
					<p>$price</p>
				</div>
			</c:forEach>
		</div>
		<div class="total">Order total count item(s) with total: money</div>
		<div>
			<form action="checkout">
				<input type="submit" value="Checkout" id="checkoutBtn" />
			</form>
		</div>
	</div>
</body>
</html>