<%@ include file="layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>

	<div class="jumbotron text-center">
		<h1>Welcome ${userName } to your shopping cart.</h1>
	</div>
	
	<c:choose>

		<c:when test="${empty cart}">
			<h3>you have no items in your shopping cart</h3>
		</c:when>
		<c:otherwise>
			<div>
				<div class="row">
					<div class="col">
						<form action="cart" method="GET">
							<table class="table">
								<thead>

									<tr>
										<th>Cart ID</th>
										<th>Item ID</th>
										<th>Name</th> 
										<th>Description</th>
										<th>Price</th>
										<th>Stock Qty</th>
										<th>Qty Ordered</th>
										<th>SubTotal</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cart" items="${cart}">
									<tr>
											<td><c:out value="${cart.cartId }" /></td>
											<td><c:out value="${cart.product.productId }" /></td>
											<td><c:out value="${cart.product.productName }" /></td>											
											<td><c:out value="${cart.product.productDescription }" /></td>
											<td><fmt:formatNumber value="${ cart.product.productPrice} " type="currency" /></td>
											<td><c:out value="${cart.product.productStock }" /></td>
											<td><c:out value="${cart.quantity }" /></td>
											<td><fmt:formatNumber value="${ cart.subTotalForItem} " type="currency" /></td>
									</tr>
							</c:forEach>
							</table>
						</form>
					</div>
					<div class="col">
						<h2>Total cost</h2>
						
						</div>



						<div>
							<a type="button" class="btn btn-danger" href="/checkout">Check
								Out </a>
						</div>

					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

<script src="/123Grocery/src/main/resources/static/calc_total.js"> </script>
</body>
</html>