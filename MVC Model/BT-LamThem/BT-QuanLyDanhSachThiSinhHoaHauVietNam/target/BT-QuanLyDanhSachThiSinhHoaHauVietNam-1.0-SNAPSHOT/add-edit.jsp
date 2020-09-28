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
    <title>Thêm hoặc sửa thông tin thí sinh</title>
</head>

<body>
<h1>Tạo hoặc chỉnh sửa thông tin khách hàng</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/">Trở lại</a>
</p>
<form method="post" action="/?action=create">
    <fieldset>
        <legend>Thông tin thí sinh</legend>
        <table>
            <tr>
                <td>Họ tên: </td>
                <td><input type="text" name="ten" id="ten" value="${requestScope['thiSinh'].getHoTen()}"></td>
            </tr>
            <tr>
                <td>Ngày sinh: </td>
                <td><input type="text" name="ngaySinh" id="ngaySinh" value="${requestScope['thiSinh'].getNgaySinh()}"></td>
            </tr>
            <tr>
                <td>Địa chỉ: </td>
                <td><input type="text" name="diaChiCuTru" id="diaChiCuTru" value="${requestScope['thiSinh'].getDiaChiCuTru()}"></td>
            </tr>
            <tr>
                <td>Số điện thoại : </td>
                <td><input type="text" name="sdt" id="sdt" value="${requestScope['thiSinh'].getSdt()}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${requestScope['thiSinh'].getEmail()}"></td>
            </tr>
            <tr>
                <td>Chứng minh thư: </td>
                <td><input type="text" name="cmt" id="cmt" value="${requestScope['thiSinh'].getCmt()}"></td>
            </tr>
            <tr>
                <td>Nghề nghiệp: </td>
                <td><input type="text" name="ngheNghiep" id="ngheNghiep" value="${requestScope['thiSinh'].getNgheNghiep()}"></td>
            </tr>
            <tr>
                <td>Trình độ văn hóa: </td>
                <td><input type="text" name="trinhDoVH" id="trinhDoVH" value="${requestScope['thiSinh'].getTrinhDoVanHoa()}"></td>
            </tr>
            <tr>
                <td>Dân tộc: </td>
                <td><input type="text" name="danToc" id="danToc" value="${requestScope['thiSinh'].getDanToc()}"></td>
            </tr>
            <tr>
                <td>Đơn vị công tác: </td>
                <td><input type="text" name="donViCongTac" id="donViCongTac" value="${requestScope['thiSinh'].getDonViCongTac()}"></td>
            </tr>
            <tr>
                <td>Chiều cao: </td>
                <td><input type="text" name="chieuCao" id="chieuCao" value="${requestScope['thiSinh'].getChieuCao()}"></td>
            </tr>
            <tr>
                <td>Cân nặng: </td>
                <td><input type="text" name="canNang" id="canNang" value="${requestScope['thiSinh'].getCanNang()}"></td>
            </tr>
            <tr>
                <td>Năng khiếu khác: </td>
                <td><input type="text" name="nangKieuKhac" id="nangKieuKhac" value="${requestScope['thiSinh'].getNangKieuKhac()}"></td>
            </tr>
            <tr>
                <td>Ảnh cá nhân: </td>
                <td><input type="text" name="anhCaNhan" id="anhCaNhan" value="${requestScope['thiSinh'].getAnhCaNhan()}"></td>
            </tr>
            <tr>
                <td>Đại diện tỉnh thành: </td>
                <td><select  name="daiDienTinhThanh" id="daiDienTinhThanh">
                        <option value="${thiSinh.daiDienTinhThanh.getIdTinh()}">${thiSinh.daiDienTinhThanh.getTenTinh()}</option>
                        <c:forEach items="${listTinhThanh}" var="tinhThanh">
                            <option value="${tinhThanh.idTinh}">${tinhThanh.tenTinh}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" id="id" value="${requestScope['thiSinh'].getId()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Xong"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
