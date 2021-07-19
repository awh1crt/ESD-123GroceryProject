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
<%-- 									<c:forEach var="cart" items="${cart}"> --%>
										<c:forEach var="products" items="${products}">
										
										<tr>
<%-- 											<td><c:out value="${cart.cartId }" /></td> --%>
										
											<td><c:out value="${products.productId}" /></td>	
<%-- 											<td><c:out value="${products.product}" /></td>					 --%>
										</tr>
									</c:forEach>
<!-- 									</tbody> -->
<%-- 											<td><c:out value="${cart.productId}" /></td> --%>
<%-- 											<td><fmt:formatNumber --%>
<%-- <%-- 													value="${ cart.productId} " type="currency" /></td> --%> --%>
<%-- <%-- 											<td><c:out value="${ cart.productId}" /></td> --%> --%>
<%-- <%-- 											<td><input type="number" value="${cart.quantity}" --%> --%>
<%-- 												class="form-control" /></td> --%>
<%-- 											<td><fmt:formatNumber --%>
<%-- <%-- 													value="${ cart.quantity * cart.productId}" --%> --%>
<%-- <%-- 													type="currency" /></td> --%> --%>
<%-- 											<td><a class="fas fa-trash icon-dark" --%>
<%-- <%-- 												href="/removeFromCart?id=${ cart.productId}"> </a></td> --%> --%>

<!-- 							<div class="col"> -->
							
<!-- <!-- 								<thead> --> -->

<!-- <!-- 									<tr> --> -->
<!-- <!-- 										<th>Name</th> --> -->
<!-- <!-- 										<th>Description</th> --> -->
<!-- <!-- 										<th>Price</th> --> -->
<!-- <!-- 										<th>Stock Qty</th> --> -->
<!-- <!-- 										<th>Qty Ordered</th> --> -->
<!-- <!-- 										<th>SubTotal</th> --> -->

<!-- <!-- 									</tr> --> -->
<!-- <!-- 								</thead> --> -->
<!-- <!-- 								<tbody> --> -->
<%-- 									<c:forEach var="products" items="${products}"> --%>
<!-- 										<tr>				 -->
<%--  											<td><c:out value="${products.productId}" /></td> --%>
<!--  										</tr> -->
<%-- 								</c:forEach> --%>

<!-- 								</tbody> -->
							</table>
						</form>
					</div>
					<div class="col">
						<h2>Total cost</h2>



						<div>
							<a type="button" class="btn btn-danger" href="/checkout">Check
								Out </a>
						</div>

					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>


</body>
</html>