<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/25
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tìm kiếm sản phẩm</title>
</head>
<body>
<form action="products?action=find" method="post">
    <fieldset>
        <legend>Nhập tên sản phẩm</legend>
        <input type="text" name="name" placeholder="Tên sản phẩm">
        <button type="submit">Tìm</button>
    </fieldset>
</form>
</body>
</html>
