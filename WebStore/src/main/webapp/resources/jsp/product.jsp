<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<jsp:include page="basic.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/product.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="product">
		<section>
			<div class="col-sm-12">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div class="carousel-caption">
								<h2>Samsung. At its best on our network.</h2>
								<p>The Galaxy S7 from Samsung is packed with innovative technology making
								 it one of the top smartphones of 2016.</p>
								 <a href="" class="btn"><img src="resources/image/button_cart.png"/>Buy now</a>
							</div>
							<img src="resources/image/slide1.jpg" alt="Chania">
						</div>

						<div class="item">
							<img src="resources/image/slide2.jpg" alt="Chania">
							<div class="carousel-caption">
								<h2>Apple iPhone 7</h2>
								<p>The phone comes with a 4.70-inch touchscreen display 
								with a resolution of 750 pixels by 1334 pixels at a PPI of 326 pixels per inch.</p>
								<a href="" class="btn"><img src="resources/image/button_cart.png"/>Buy now</a>
							</div>
						</div>

						<div class="item">
							<img src="resources/image/slide3.jpg" alt="Flower">
							<div class="carousel-caption">
								<h2>XiaoMi Mi 5</h2>
								<p>Snapdragon 820 / 3GB RAM / 32GB UFS 2.0 Flash 4-axis OIS camera / 3D glass body</p>
								<a href="" class="btn"><img src="resources/image/button_cart.png"/>Buy now</a>
							</div>
						</div>

						<div class="item">
							<img src="resources/image/slide4.jpg" alt="Flower">
							<div class="carousel-caption">
								<h2>Lenovo K5 Note 4G</h2>
								<p>This item features a 5.5" multi-point capacitive touch screen with 1920 * 1080 resolution, 
								dual SIM card and dual standby design.</p>
								<a href="" class="btn"><img src="resources/image/button_cart.png"/>Buy now</a>
							</div>
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> 
						<span><span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</section>
		<section>
			<div id="featureProduct">
				<h1>Featured products</h1>
				<div class="rowProduct">
					<c:forEach items="${products}" var="product" begin="0" end="5">
						<div class="information">
							<a href="productDetail.do?productId=${product.productId}"><img alt="${product.productName}" src="resources/image/${product.firstImage}"/></a>
							<div class="description">
								<h4>${product.productName}</h4> 
								<p>${product.price}$</p>
							</div>
							<div class="detailBtn">
								<div>
									<c:if test="${product.count > 0}"><a href="product.do?addCart=${product.productId}">Add To Cart</a></c:if>
								</div>																																																						
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>