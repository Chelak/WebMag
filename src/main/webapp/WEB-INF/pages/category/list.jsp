<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Category List</title>
    <link type="text/css"  href="<c:url value="/resources"/>" rel="stylesheet" />
</head>
<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-default" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">Home</a></li>
                <li><a href="<c:url value="/category/"/>">Category</a></li>
                <li><a href="<c:url value="/product/"/>">Product</a></li>
            </ul>
        </nav></div>
</div>
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
</body>
</html>