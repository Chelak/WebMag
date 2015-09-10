<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<link href="/resources/css/bootstrap.css" rel="stylesheet">
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<!-- Memu Start-->
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebStore</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/category">Category</a></li>
				<li><a href="/products">Products</a></li>
				<li><a href="/admin">Admin</a></li>
			</ul>
		</div>
	</div>
</nav>



<!-- Memu End-->
<h1>${message}</h1>

<div>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
			<th>Product in Stock</th>

		</tr>
		</thead>
		<tbody>
	<c:forEach items="${products}" var="products">
		<tr>
			<td>${products.productId}</td>
			<td>${products.productName}</td>
			<td><i>${products.productDescription}</i></td>
			<td>${products.productPrice}</td>
			<td>${products.productStock}</td>


		</tr>
	</c:forEach>
		</tbody>
	</table>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>