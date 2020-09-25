<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/25
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Tạo hoặc chỉnh sửa thông tin khách hàng</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="products">Trở lại</a>
</p>
<form method="post" action="products?action=create">
    <fieldset>
        <legend>Thông tin khách hàng</legend>
        <table>
            <tr>
                <td>Tên sản phẩm: </td>
                <td><input type="text" name="name" id="name" value="${requestScope['product'].getName()}"></td>
            </tr>
            <tr>
                <td>Hãng sản xuất : </td>
                <td><input type="text" name="manufacturer" id="manufacturer"
                           value="${requestScope['product'].getManufacturer()}"></td>
            </tr>
            <tr>
                <td>Giá: </td>
                <td><input type="text" name="price" id="price" value="${requestScope['product'].getPrice()}"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" id="id" value="${requestScope['product'].getId()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Xong"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
