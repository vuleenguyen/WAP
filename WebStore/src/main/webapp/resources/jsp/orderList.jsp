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
			<h1>Shopping Cart</h1>
			<c:forEach items="${sessionScope['cart'].products}" var="product">
				<div class="goodCheckout">
					<a><img alt="linj" src="<c:url value="resources/image/${product.firstImage}"/>"></a>
					<h3>${product.productName}</h3>
					<p>$${product.price}</p>
					<a class="delete" href="<c:url value='orderList?action=delete&productId=${product.productId}'/>">Delete</a>
				</div>
			</c:forEach>
		</div>
		<div class="total">Sub total (${sessionScope['cart'].size} item(s)): <span>${money}$</span></div>
		<div>
			
			<c:if test="${not empty sessionScope['cart'].products}">
					<a href="checkout" id="checkoutBtn">Checkout</a>
			</c:if>
		</div>
	</div>
</body>
</html>