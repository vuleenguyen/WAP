
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Page</title>
<jsp:include page="basic.jsp"></jsp:include>
</head>
<body>
	<div id="checkout">
		<div class="container">
			<form action="checkout" method="post">
				<h1>Information Order</h1>
				<c:if test="${not empty error}">
					<p style="color: red; font-weight: bold">${errors}</p>
				</c:if>
				<div class="form-group">
					<label for="street">Street:</label> <input type="text"
						class="form-control" id="street" placeholder="Enter street.."
						name="street" required>
				</div>

				<div class="form-group">
					<label for="city">City:</label> <input type="text"
						class="form-control" id="city" placeholder="Enter city.."
						name="city" required>
				</div>

				<div class="form-group">
					<label for="zipCode">ZipCode:</label> <input type="text"
						class="form-control" id="zipCode" placeholder="Enter zipCode.."
						name="zipCode" required>
				</div>

				<div class="form-group">
					<label for="state">State:</label> <input type="text"
						class="form-control" id="state" placeholder="Enter state.."
						name="state" required>
				</div>

				<div class="form-group">
					<label for="phone">Phone Number:</label> <input type="text"
						class="form-control" id="phone" placeholder="Enter phone number.."
						name="phone" required>
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="email"
						class="form-control" id="email" placeholder="Enter email.."
						name="email" required>
				</div>
				
				<div class="form-group">
					<label for="cartNumber">CartNumber:</label> <input type="text"
						class="form-control" id="cartNumber" placeholder="Cart Number.."
						name="cartNumber" required>
				</div>
				
				<div class="group-card">
					<ul class="cart-list">
						<li><img alt="visa" src="resources/image/visa.png"></li>
						<li><img alt="mastercard"
							src="resources/image/mastercard.png"></li>
						<li><img alt="paycard" src="resources/image/paycard.png"></li>
						<li><img alt="express" src="resources/image/express.png"></li>
						<li><img alt="paypal" src="resources/image/paypal.png"></li>
					</ul>
				</div>
				
				<div class="amount">Total Amount: <span>${sessionScope['cart'].money}$</span></div>

				<input type="submit" class="btn btn-danger" value="Finish" id="" />
			</form>
		</div>
	</div>


</body>
</html>