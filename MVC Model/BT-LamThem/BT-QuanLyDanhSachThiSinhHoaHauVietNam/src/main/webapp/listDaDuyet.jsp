<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/28
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách đã duyệt</title>
</head>
<body>
<h2>Danh sách đã duyệt</h2>

<a href="/"> Danh sách đăng ký </a>
<table border="1" cellspacing="0">
    <thead>
    <tr>
        <th rowspan="2">Họ Tên</th>
        <th rowspan="2">Ngày sinh</th>
        <th colspan="2">Thông tin liên lạc</th>
        <th rowspan="2">Cân nặng</th>
        <th rowspan="2">Chiều cao</th>
        <th rowspan="2">Tỉnh thành</th>
        <th rowspan="2">Ảnh</th>
    </tr>
    <tr>
        <th>Số điện thoại</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDaDuyet}" var="thiSinh">
        <tr>
            <td><a href="${pageContext.request.contextPath}/?action=view&id=${thiSinh.id}">
                    ${thiSinh.hoTen}</a>
            </td>
            <td>${thiSinh.ngaySinh}
            </td >
            <td>${thiSinh.sdt}
            </td>
            <td>${thiSinh.email}
            </td>
            <td>${thiSinh.canNang}
            </td>
            <td>${thiSinh.chieuCao}
            </td>
            <td>${thiSinh.daiDienTinhThanh.getTenTinh()}
            </td>
            <td> <img src="<c:url value='${thiSinh.anhCaNhan}'/>" alt="anh" width="50px" height="50px">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
