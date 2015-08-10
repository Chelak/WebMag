<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<html>
<head>
  <title>Edit category</title>
  <link type="text/css"
        href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" />
</head>
<body>
<div class="container">
  <div class="row">
    <nav class="navbar navbar-default" role="navigation">
      <ul class="nav navbar-nav">
        <li><a href="<c:url value="/"/>">Home</a></li>
        <li><a href="<c:url value="/category/"/>">Category</a></li>
        <li><a href="<c:url value="/product"/>">Product</a></li>
      </ul>
    </nav></div>
</div>
<div class="container">
  <div class="row">
    <h1>Edit Category</h1>
    <form:form action="editConfirm" method="post"
               commandName="categoryEdit" cssClass="form-horizontal">
      <form:hidden path="categoryId" id="categoryId" />
      <div class="form-group">
        <label for="categoryName">Category Name</label>
        <form:input path="categoryName" id="categoryName" /></div>
      <div class="form-group">
        <label for="categoryDescription">Category Description</label>
        <form:textarea path="categoryDescription" id="categoryDescription" /></div>
      <div class="form-group">
        <button type="submit" class="btn btn-default btn-success">Save</button></div>
    </form:form></div>
</div>
</body>
</html>