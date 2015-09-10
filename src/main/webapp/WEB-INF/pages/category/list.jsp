<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Category List</title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
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
<h1>${message}</h1>
<div class="container">
    <div class="row">
        <h1>Category List</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.categoryName}
                        <i>${category.categoryDescription}</i></td>
                    <td><a
                            href="<c:url value="/category/edit/${category.categoryId}"/>">Edit</a></td>
                    <td><a
                            href="<c:url value="/category/delete/${category.categoryId}"/>">Delete</a></td>
                </tr>
            </c:forEach></tbody>
        </table>
        <a href="<c:url value="/category/add"/>">Add new category</a></div>
</div>
<div class="container">
    <div class="row">
        <c:forEach items="${categories}" var="category">
            <button type="button" class="btn btn-primary" onclick="window.location.href='/category/${category.categoryId}'" >${category.categoryName} </button>

        </c:forEach>
    </div>

</div>
<div class="container">
    <div class="row">
        <table class="table table-bordered">
            <tr>
                <th>#</th>
                <th>Category</th>
                <th>Category description</th>
            </tr>
            <tbody>
            <tr>

                <td>${categoryId}</td>
                <td>${categoryName}</td>
                   <td>${categoryDescription}</td>

            </tr>
            </tbody>
        </table>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/js/bootstrap.js"></script>
</body>
</html>