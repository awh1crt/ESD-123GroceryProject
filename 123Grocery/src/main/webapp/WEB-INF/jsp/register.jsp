<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Registration Page</title>
</head>
<body>
<div class="container text-center">
	<div>
		<h1>To Register fill the details below</h1>
	</div>
	
		

			<form action="/register" method="post" style="max-width: 900px; margin: 0; auto">
				
				<div class="form-group">
					<label class = "form-column-label col-4" for="ufirstname">First Name :</label> <input type="text"
						name="ufirstname" class="from-control" placeholder="John" required>
				</div>
				<div class="form-group">
					<label class = "form-column-label col-4" for="ulastname">Last Name :</label> <input type="text"
						name="ulastname" class="from-control" placeholder="John" required>
				</div>
				<div class="form-group">
					<label class = "form-column-label col-4" for="upass">Password :</label> <input type="password"
						name="upass" class="from-control" placeholder="*******" required>
				</div>
				<div class="form-group">
					<label class = "form-column-label col-4" for="uemail">Email : </label> <input type="email" name="uemail"
						class="from-control" placeholder="john.smith@johnsmith.me" required>
				</div>
				
				<div class="form-group">
					<label class = "form-column-label col-4" for="uaddress">Address :</label> <input type="text"
						name="uaddress" class="from-control" placeholder="London" required>
				</div>
				<div>
					<button type="submit" class="btn btn-primary" >Register</button>
				</div>
				
			</form>
		</div>
</body>
</html>