<%@ include file="layout/header.jsp"%>

<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>

	<form action="searchProductResults" method="GET">
		<table class="table">
			<thead>

				<tr>
					<th>Name</th>
					<th>Description</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${product}">
					<tr>
						<td><c:out value="${ product.productName}" /></td>
						<td><c:out value="${ product.productDescription}" /></td>
						<td><c:out value="${ product.productPrice}" /></td>
						<td><c:out value="${ product.productStock}" /></td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteProduct?id=${ product.productId}">Delete
								${product.productId}</a></td>
						<td><a type="button" class="btn btn-success"
							href="/selectProduct?id=${ product.productId}">Select
								${product.productId}</a></td>
						<td><a type="button" class="btn btn-primary"
							href="/buyProduct?id=${product.productId }">Buy</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</form>
	<br>
	<a href="/home">Home Page</a>
</body>