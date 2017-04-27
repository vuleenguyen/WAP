<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product detail</title>
<jsp:include page="basic.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="productDetail">
		<div class="col-sm-8">
			<div class="col-sm-2">
				<div><img src="resources/image/${product.firstImage}"/></div>
				<div><img src="resources/image/${product.secondImage}"/></div>
				<div><img src="resources/image/${product.firstImage}"/></div>
				<div><img src="resources/image/${product.secondImage}"/></div>
			</div>
			<div class="col-sm-10">
				<div><img id="productImage" alt="${product.productName}" src="resources/image/${product.firstImage}" data-zoom-image="resources/image/${product.firstImage}"/></div>
			</div>
		</div>
		<div class="col-sm-4">
			<h3>${product.productName}</h3>
			<h4>${product.price}$</h4>
			<div><strong>Brand: </strong> ${product.brand}</div>
			<div><strong>ProductCode: </strong> ${product.productId}</div>
			<div class="available"><strong>Availability: </strong>
				<c:choose>
					<c:when test="${product.count > 0}">
						<label>In Stock</label>
					</c:when>
					<c:otherwise>
						<label>Out Of Stock</label>
					</c:otherwise>
				</c:choose>
			</div>
			<div><strong>Detail Stock: </strong></div>
			<div class="detail">${product.detailInformation}</div>
			<button type="button" class="button-search" onclick="location.href='product.do?addCart=${product.productId}';" 
					<c:if test="${product.count == 0}">disabled</c:if>>
					<span class="glyphicon glyphicon-shopping-cart"></span>
					Add to cart
			</button>
			
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>