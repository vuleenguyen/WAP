<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="basic.jsp"></jsp:include>
<script type="text/javascript" src="resources/js/script.js"></script>
</head>
<body>
	<div id="product">
		<header>
			<div class="col-sm-2">
				<h1 id="logo" class="logo">
					<a href=""> <img alt="Mobilli" title="Mobilli"
						src="https://livedemo00.template-help.com/opencart_62184/image/catalog/logo.png"
						class="img-responsive">
					</a>
				</h1>
				<div class="menu-toggle-wrap">
					<div class="menu-toggle">
						<span class="glyphicon glyphicon-align-justify"></span>
					</div>
					<div class="toggle-cont-menu">
						<div class="navigation">
							<div class="megamenu">
								<ul class="sf-menu sf-js-enabled sf-arrows">
									<li><a> iPhones </a></li>
									<li><a> Special Offers </a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div id="search" class="search">
					<input type="text" name="search">
					<button type="button" class="button-search">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="header_modules">
					<div>
						<i class="glyphicon glyphicon-earphone"></i> <span>Free
							support call:</span>
						<p>1 800 123 45 67</p>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div id="cart">
					<a><img src="resources/image/cart.png" /><span>0</span></a>
				</div>
				<div>
					<span id="cart-total" class="cart-total"> 0.00$ </span>
				</div>
			</div>
			<div class="col-sm-1">
			</div>
		</header>
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
					<div class="information">
						<img alt="product1" src="resources/image/product1.png"/>
						<div class="description">
							<h4>Elephone G5 5.5 inch Android</h4>
							<p>50.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
					<div class="information">
						<img alt="product2" src="resources/image/product2.png"/>
						<div class="description">
							<h4>BLU Studio 5.0 C HD Smartphone</h4>
							<p>32.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
					<div class="information">
						<img alt="product3" src="resources/image/product3.png"/>
						<div class="description">
							<h4>Alcatel One Fierce Prepaid Phone</h4>
							<p>64.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
					<div class="information">
						<img alt="product4" src="resources/image/product4.png"/>
						<div class="description">
							<h4>ASUS ZENFONE 6 A601CG</h4>
							<p>64.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
					<div class="information">
						<img alt="product5" src="resources/image/product5.png"/>
						<div class="description">
							<h4>Samsung Galaxy S4 SGH-M919</h4>
							<p>40.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
					<div class="information">
						<img alt="product6" src="resources/image/product6.png"/>
						<div class="description">
							<h4>Samsung Galaxy S III</h4>
							<p>24.00$</p>
						</div>
						<div class="detailBtn">
							<div>
								<a href="">Detail</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>