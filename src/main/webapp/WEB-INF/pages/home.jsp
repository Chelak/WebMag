<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

</head>
<body>
<!-- Memu Start-->
<div align="center">
	<nav>
		<ul>
			<button type="button" onclick="window.location.href='/'" >Home</button>
			<button type="button" onclick="window.location.href='/category'">Category</button>
			<button type="button" onclick="window.location.href='/products'">Products</button>
			<button type="button" onclick="window.location.href='/admin'">Admin</button>

		</ul>
	</nav>
</div>

<!-- Memu End-->
<h1>${message}</h1>


</body>
</html>