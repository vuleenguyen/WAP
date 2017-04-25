<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<jsp:include page="basic.jsp"></jsp:include>
		<script type="text/javascript" src="resources/js/insertProduct.js"></script>
	</head>
<body>
	<div id="insertProduct">
		<form id="formProduct" action="manager" method="post" enctype="multipart/form-data">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="productName">Name:</label> <input type="text"
						class="form-control" id="productName"
						placeholder="Enter product name.." name="productName" required>
				</div>
				<div class="form-group">
					<label for="briefInformation">Brief Information</label>
					<textarea class="form-control" rows="2" id="briefInformation"
						name="briefInformation" required></textarea>
				</div>
				<div class="form-group">
					<label for="detailInformation">Detail Information</label>
					<textarea class="form-control" rows="3" id="detailInformation"
						name="detailInformation"></textarea>
				</div>
				<div class="form-group">
					<label for="brand">Brand</label> <select class="form-control"
						id="brand" name="brand">
						<option>Iphone</option>
						<option>SamSung</option>
						<option>LG</option>
						<option>Asus</option>
					</select>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label for="price">Price</label> <input type="number" step="0.01"
						class="form-control" id="price" name="price"
						placeholder="Enter price here.." required />
				</div>
				<div class="form-group">
					<label for="firstImage">First Image</label> <input type="file"
						class="form-control" id="firstImage" name="firstImage"
						placeholder="Upload Image here.." required>
				</div>
				<div class="form-group">
					<label for="secondImage">Second Image</label> <input type="file"
						class="form-control" id="secondImage" name="secondImage"
						placeholder="Upload Image here.." required>
				</div>
				<div class="form-group">
					<label for="count">Quantity</label> <input type="number"
						class="form-control" name="count" id="quantity" placeholder="Enter quantity.."/>
				</div>
				<button type="submit" class="btn btn-success">Add Product</button>
			</div>
		</form>
	</div>
</body>
</html>