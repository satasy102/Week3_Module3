<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/25
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<a href="products?action=create"> Thêm sản phẩm </a>
<a href="products?action=find"> Tìm sản phẩm </a>

<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Hãng sản xuất</th>
        <th>Giá</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope['product']}" var="product">
        <tr>
            <td><a href="products?action=view&id=${product.id}">
                    ${product.name}</a>
            </td>
            <td>${product.manufacturer}
            </td>
            <td>${product.price}
            </td>
            <td>
                <a href="products?action=update&id=${product.getId()}">edit/</a>
                <a href="#" onclick="abc(${product.getId()},'${product.getName()}',
                        '${product.getPrice()}')">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="products?"> Danh sách sản phẩm </a>
<script>
    function abc(id,name,price){
        let messenger= "Bạn có chắc xóa "+name+" có số giá: "+price+" này không?";

        if(confirm(messenger)){
            window.location = "products?action=delete&id="+id;
        }
    }
</script>
</body>
</html>
