<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/28
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách thí sinh đăng ký</title>
</head>
<body>
<a href="/?action=create"> Đăng ký </a> <br>


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
        <th rowspan="2">Xét duyệt</th>
        <th rowspan="2">Thao tác</th>
    </tr>
    <tr>
        <th>Số điện thoại</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listThiSinh}" var="thiSinh">
        <tr>
            <td><a href="/?action=view&id=${thiSinh.id}">
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
            <td><a href="/?action=xetduyet&id=${thiSinh.id}">
                <c:choose>
                    <c:when test = "${thiSinh.duyet==true}">
                        <c:out value = "Đã duyệt"/>
                    </c:when>
                    <c:when test = "${thiSinh.duyet==false}">
                        <c:out value = "Duyệt"/>
                    </c:when>
                </c:choose>
            </a>
            </td>
            <td>
                <a href="/?action=update&id=${thiSinh.id}">Sửa/</a>
                <a href="#" onclick="abc(${thiSinh.id},'${thiSinh.hoTen}',
                        '${thiSinh.sdt}')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/?action=daduyet"> Danh sách đã được duyệt </a>
<script>
    function abc(id,name,phone){
        let messenger= "Bạn có chắc xóa "+name+" có số điện thoại: "+phone+" này không?";

        if(confirm(messenger)){
            window.location = "/?action=delete&id="+id;
        }
    }

</script>
</body>
</html>
