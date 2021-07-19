<%@ include file="layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="productDetails" method="GET">

		<table class="table">
			<thead>

				<tr>
					<th>Name</th>
					<th>Description</th>

				</tr>
			</thead>
			<tbody>

				<tr>
					<td><c:out value="${ product.productName}" /></td>
					<td><c:out value="${ product.productDescription}" /></td>
					<td><c:out value="${ product.productPrice}" /></td>
					<td><c:out value="${ product.productStock}" /></td>
					<td>
						<div class="form-group">
							<input type="email" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="Enter Quantity">
						</div>
					</td>
					<td><a type="button" class="btn btn-primary"
						href="/buyProduct?id=${product.productId }">Buy</a></td>
				</tr>


			</tbody>
		</table>
	</form>

	<br>
	<a href="/home">Home Page</a>
</body>
</html>