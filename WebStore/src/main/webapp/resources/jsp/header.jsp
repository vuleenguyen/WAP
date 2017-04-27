<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" uri="/WEB-INF/CustomTag.tld"%>
<div id="header">
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
								<c:if test="${sessionScope['user'].roletoMapping == 'manager'}">
									<li><a href="<c:url value='AdminPanel'/>"> Product
											Manager </a></li>
								</c:if>
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
				<a href="orderList.do"><img src="resources/image/cart.png" /><c:choose><c:when test="${not empty sessionScope['cart']}"><span>${sessionScope['cart'].size}</span></c:when><c:otherwise><span>0</span></c:otherwise></c:choose>
				</a>
			</div>
			<div>
				<span id="cart-total" class="cart-total"> <ct:span fontWeight="700" color="#b12704" fontSize="14px !important" text="${sessionScope['cart'].money}$"/> </span>
			</div>
			<c:choose>
				<c:when test="${not empty sessionScope['user']}">
					<a href='<c:url value="profile"/>'><img alt="user" src="resources/image/user.png"/></a>
					<a href='<c:url value="login.do"/>'>Logout</a> 
				</c:when>
				<c:otherwise>
					<a href='<c:url value="login.do"/>'>Login</a>
				</c:otherwise>
			</c:choose>
			<div></div>
		</div>
		<div class="col-sm-1"></div>
	</header>
</div>