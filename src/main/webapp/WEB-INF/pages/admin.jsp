<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/5/2015
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <h1>${message1}</h1>

  <form action="/admin/add-category" method="post">
    <p><input type="text" name="category_name" placeholder="Category title"/></p>
    <p><input type="text" name="category_description" placeholder="Description"/></p>
    <p><input type="submit" value="Add Category"/></p>
  </form>
</div>
<br>
<br>
<div align="center">
  <h1>${message2}</h1>
  <form action="/admin/add-product" method="post">
    <p><input type="text" name="product_name" placeholder="Product title"/></p>
    <p><input type="text" name="product_stock" placeholder="Product Stock"/></p>
    <p><input type="text" name="product_price" placeholder="Product Price"/></p>
    <p><input type="text" name="product_description" placeholder="Description"/></p>
    <p><input type="submit" value="Add Product"/></p>
  </form>
</div>

</body>
</html>
