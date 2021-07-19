<%@ include file="layout/header.jsp"%>

<title>Add New Product</title>
</head>
<body>

	<h1>Add Product</h1>
	<div class="col-md-8">

		<a href="addProduct">Add User</a>

		<form action="/addProduct" method="POST">
			<div class="form-group">
				Product Name: <input type="text" class="form-control"
					placeholder="Product Name" name="productName"> <br>


				Product Description: <input type="text" class="form-control"
					placeholder="Product Description" name="productDescription">
				<br> Product Price: <input type="text" class="form-control"
					placeholder="Product Price" name="productPrice"> <br>
				Product Stock: <input type="text" class="form-control"
					placeholder="Product Stock" name="productStock"> <br>


				<button type="submit" class="btn btn-primary">Click to add</button>
			</div>

		</form>
	</div>
</body>
</html>
</html>