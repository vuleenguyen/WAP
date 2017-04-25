<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
<jsp:include page="basic.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div id="adminPanel">
		<div class="main">
			<h3 class="displayInline">Admin Panel</h3>
			<a href="manager?action=insert" id="addProduct" class="blue-text btn btn-primary fr"><span class="glyphicon glyphicon-open" aria-hidden="true"></span> Add new product</a>
			
			<table class="table" id="product_table">
				<thead>
					<tr>
						<th>#</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td id="id" scope="row">1</td>
						<td id="name">Abby</td>
						<td id="price">Abby</td>
						<td id="actions">
							<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
						</td>
					</tr>
					<tr>
						<td id="id" scope="row">2</td>
						<td id="name">Abby</td>
						<td id="price">Abby</td>
						<td id="actions">
							<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
						</td>
					</tr>
					<tr>
						<td id="id" scope="row">3</td>
						<td id="name">Abby</td>
						<td id="price">Abby</td>
						<td id="actions">
							<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
						</td>
					</tr>
					<tr>
						<td id="id" scope="row">4</td>
						<td id="name">Abby</td>
						<td id="price">Abby</td>
						<td id="actions">
							<a href="#" id="removeProduct" class="blue-text"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
							<a href="#" id="updateProduct" class="blue-text"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>