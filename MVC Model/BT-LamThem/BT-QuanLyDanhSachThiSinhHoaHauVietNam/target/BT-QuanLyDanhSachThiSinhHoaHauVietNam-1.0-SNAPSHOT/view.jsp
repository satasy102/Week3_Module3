<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/28
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin chi tiết thí sinh</title>
</head>

<body>
<h1>Thông tin chi tiết thí sinh</h1>

<p>
    <a href="/">Trở lại</a>
</p>
    <fieldset>
        <legend>Thông tin chi tiết thí sinh</legend>
        <table>
            <tr>
                <td>Họ tên: </td>
                <td>${requestScope['thiSinh'].getHoTen()}</td>
            </tr>
            <tr>
                <td>Ngày sinh: </td>
                <td>${requestScope['thiSinh'].getNgaySinh()}</td>
            </tr>
            <tr>
                <td>Địa chỉ: </td>
                <td>${requestScope['thiSinh'].getDiaChiCuTru()}</td>
            </tr>
            <tr>
                <td>Số điện thoại : </td>
                <td>${requestScope['thiSinh'].getSdt()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope['thiSinh'].getEmail()}</td>
            </tr>
            <tr>
                <td>Chứng minh thư: </td>
                <td>${requestScope['thiSinh'].getCmt()}</td>
            </tr>
            <tr>
                <td>Nghề nghiệp: </td>
                <td>${requestScope['thiSinh'].getNgheNghiep()}</td>
            </tr>
            <tr>
                <td>Trình độ văn hóa: </td>
                <td>${requestScope['thiSinh'].getTrinhDoVanHoa()}</td>
            </tr>
            <tr>
                <td>Dân tộc: </td>
                <td>${requestScope['thiSinh'].getDanToc()}</td>
            </tr>
            <tr>
                <td>Đơn vị công tác: </td>
                <td>${requestScope['thiSinh'].getDonViCongTac()}</td>
            </tr>
            <tr>
                <td>Chiều cao: </td>
                <td>${requestScope['thiSinh'].getChieuCao()}</td>
            </tr>
            <tr>
                <td>Cân nặng: </td>
                <td>${requestScope['thiSinh'].getCanNang()}</td>
            </tr>
            <tr>
                <td>Năng khiếu khác: </td>
                <td>${requestScope['thiSinh'].getNangKieuKhac()}</td>
            </tr>
            <tr>
                <td>Đại diện tỉnh thành: </td>
                <td>${requestScope['thiSinh'].daiDienTinhThanh.getTenTinh()}</td>
            </tr>
            <tr>
                <td>Ảnh cá nhân: </td>
                <td> <img src="<c:url value='${thiSinh.anhCaNhan}'/>" alt="anh" width="50px" height="50px">
            </tr>
        </table>
    </fieldset>
</body>
</html>
