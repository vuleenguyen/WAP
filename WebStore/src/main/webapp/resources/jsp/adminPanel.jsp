<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<jsp:include page="basic.jsp"></jsp:include>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div id="adminPanel">
		<div class="main">
			<h3 class="displayInline">Admin Panel</h3>
			<a href="http://localhost:8080/WebStore/manager" id="addProduct" class="blue-text btn btn-primary fr"><span class="glyphicon glyphicon-open" aria-hidden="true"></span> Add new product</a>
			
			<table class="table" id="product_table">
				<thead>
					<tr>
						<th>#</th>
						<th>Product Name</th>
						<th>Brief Information</th>
						<th>Detail Information</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${products}" var="item">
				    <tr>
						<td id="id" scope="row">${item.productId}</td>
						<td id="name">${item.productName}</td>
						<td id="binfo">${item.briefInformation}</td>
						<td id="dinfo">${item.detailInformation}</td>
						<td id="price">${item.price}</td>
						<td id="actions">
							<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
						</td>
					</tr>
				    
				</c:forEach>
									
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>