<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="customers">Trở lại</a>
</p>
<form method="post" action="customers?action=create">
    <fieldset>
        <legend>Thông tin khách hàng</legend>
        <table>
            <tr>
                <td>Họ tên: </td>
                <td><input type="text" name="name" id="name" value="${requestScope['customer'].getFullName()}"></td>
            </tr>
            <tr>
                <td>Số điện thoại : </td>
                <td><input type="text" name="phone" id="phone" value="${requestScope['customer'].getPhoneNumber()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope['customer'].getEmail()}"></td>
            </tr>
            <tr>
                <td>Ngày sinh: </td>
                <td><input type="text" name="birthday" id="birthday" value="${requestScope['customer'].getBirthday()}"></td>
            </tr>
            <tr>
                <td>Giới tính: </td>
                <td><input type="text" name="gender" id="gender" value="${requestScope['customer'].getGender()}"></td>
            </tr>
            <tr>
                <td>Địa chỉ: </td>
                <td><input type="text" name="address" id="address" value="${requestScope['customer'].getAddress()}"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" id="id" value="${requestScope['customer'].getId()}"></td>
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