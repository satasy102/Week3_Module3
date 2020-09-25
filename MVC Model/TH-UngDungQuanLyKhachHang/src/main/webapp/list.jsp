<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/25
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>

<body>
    <a href="customers?action=create"> Thêm khách hàng </a>

        <table border="1" cellspacing="0">
            <thead>
            <tr>
                <th>Họ Tên</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><a href="customers?action=view&id=${customer.getId()}">
                            ${customer.getFullName()}</a>
                    </td>
                    <td class="${customer.getId()}-phone">${customer.getPhoneNumber()}
                    </td>
                    <td class="${customer.getId()}-email">${customer.getEmail()}
                    </td>
                    <td class="${customer.getId()}-dob">${customer.getBirthday()}
                    </td >
                    <td class="${customer.getId()}-gender">${customer.getGender()}
                    </td>
                    <td class="${customer.getId()}-address">${customer.getAddress()}
                    </td>
                    <td>
                        <a href="customers?action=update&id=${customer.getId()}">edit/</a>
                        <a href="#" onclick="abc(${customer.getId()},'${customer.getFullName()}',
                    '${customer.getPhoneNumber()}')">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <script>
        function abc(id,name,phone){
            let messenger= "Bạn có chắc xóa "+name+" có số điện thoại: "+phone+" này không?";

            if(confirm(messenger)){
               window.location = "customers?action=delete&id="+id;
            }
        }
    </script>
</body>
</html>
