<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<c:url value='resources/css/footer.css' />" />
	</head>
	<body>
		<div id="first-footer">
		</div>
		<div id="second-footer">
		</div>
		<div class="aboutUS">
			<div class="col-sm-3">
				<h4>About Us</h4>
				<p>We are from many country in the word, Our Team have three people: Vu Lee, Anas, and a girl,
				We are from VietNam, Jordan, Ethiopia. Now We are students at MUM and will get success in the future</p>
			</div>
			<div class="col-sm-3 special">
				<div>
					<span class="glyphicon glyphicon-map-marker"></span>
					<span><a href="//www.google.com/maps/?q=41.018,-91.9688">1000 North 4th FairField,Iowa</a></span>	
				</div>
				<div>
					<span class="glyphicon glyphicon-earphone"></span>	
					<span><a href="callto:+1 (641) 472-7000">(641) 472-7000</a>
					</span>		
				</div>
				<div>
					<span class="glyphicon glyphicon-envelope"></span>	
					<span><a href="mailto:info@mum.org">info@mum.org</a>
					</span>			
				</div>
			</div>
			<div class="col-sm-2">
				<h4>Information</h4>
				<ul>
					<li><a>Specials</a></li>
					<li><a>About</a></li>
					<li><a>Delivery Information</a></li>
					<li><a>Privacy Policy</a></li>
					<li><a>Terms &amp; Conditions</a></li>
					<li><a>Contact Us</a></li>
					<li><a>Returns</a></li>
					<li><a>Blog</a></li>
				</ul>
			</div>
			<div class="col-sm-2">
				<h4>Categories</h4>
				<ul>
					<li><a>iPhones</a></li>
					<li><a>Special Offers</a></li>
				</ul>
			</div>
			<div class="col-sm-2">
				<h4>My account</h4>
				<ul>
					<li><a>My account</a></li>
					<li><a>Order history</a></li>
				</ul>
			</div>
		</div>
		<div class="signUpLetter">
			<div class="col-sm-6">
				<div class="col-sm-3">
					<h4>Sign up for our newsletter</h4>
				</div>
				<div class="col-sm-9">
					<input type="email" placeholder="Enter your e-mail" name="emailSignup" id="emailSignup"/>
					<input type="button" value="Subscribe" id="btnSubscribe"/>
				</div>
			</div>
			<div class="col-sm-6">
				<ul class="card-list">
					<li><img alt="visa" src="resources/image/visa.png"></li>
					<li><img alt="mastercard" src="resources/image/mastercard.png"></li>
					<li><img alt="paycard" src="resources/image/paycard.png"></li>
					<li><img alt="express" src="resources/image/express.png"></li>
					<li><img alt="paypal" src="resources/image/paypal.png"></li>
				</ul>
			</div>
		</div>
		<div class="lastfooter">
			<p>Powered By IRIS team © April 2017</p>
		</div>
	</body>
</html>