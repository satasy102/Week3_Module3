package com.chanhtin.controller;

import com.chanhtin.model.model.ThiSinh;
import com.chanhtin.model.model.TinhThanh;
import com.chanhtin.model.service.QuanLyThiSinhImpl;
import com.chanhtin.model.service.QuanLyTinhThanhIpml;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "QuanLyThiSinhServlet", urlPatterns = "/")
public class QuanLyThiSinhServlet extends HttpServlet {
    QuanLyThiSinhImpl quanLyThiSinh = new QuanLyThiSinhImpl();
    QuanLyTinhThanhIpml quanLyTinhThanh = new QuanLyTinhThanhIpml();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "";
        switch (action) {
            case "create":
                createThiSinh(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "";
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                deleteThiSinh(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            case "xetduyet":
                listThiSinh(request, response);
            case "daduyet":
                showlistDaDuyet(request, response);
            default:
                listThiSinh(request, response);
        }
    }

    private void listThiSinh(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException {

        List<ThiSinh> listThiSinh;

        try {
            Long id = Long.parseLong(request.getParameter("id"));

            ThiSinh thiSinh = quanLyThiSinh.findById(id);

            thiSinh.setDuyet(!thiSinh.isDuyet());
            quanLyThiSinh.update(thiSinh.getId(), thiSinh);

        } catch (NumberFormatException ignored) {
        } finally {
            listThiSinh = quanLyThiSinh.getAll();
            request.setAttribute("listThiSinh", listThiSinh);

            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<TinhThanh> listTinhThanh = quanLyTinhThanh.getAll();
        request.setAttribute("listTinhThanh", listTinhThanh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createThiSinh(HttpServletRequest request, HttpServletResponse response) {
        try {
            ThiSinh thiSinh = getThiSinh(request);

            quanLyThiSinh.save(thiSinh);
            request.setAttribute("message", "Thành công");

        } catch (NumberFormatException e) {
            request.setAttribute("message", "Sai dữ liệu nhập");
            long id = getId(request);
            request.setAttribute("thiSinh", quanLyThiSinh.findById(id));
        } finally {
            try {
                List<TinhThanh> listTinhThanh = quanLyTinhThanh.getAll();
                request.setAttribute("listTinhThanh", listTinhThanh);
                RequestDispatcher dispatcher = request.getRequestDispatcher("add-edit.jsp");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ThiSinh getThiSinh(HttpServletRequest request) {
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiCuTru = request.getParameter("diaChiCuTru");
        String sdt = request.getParameter("sdt");
        Long sodienthoai = Long.parseLong(sdt);
        String email = request.getParameter("email");
        String cmt = request.getParameter("cmt");
        Long cmnd = Long.parseLong(cmt);
        String ngheNghiep = request.getParameter("ngheNghiep");
        String trinhDoVH = request.getParameter("trinhDoVH");
        String danToc = request.getParameter("danToc");
        String donViCongTac = request.getParameter("donViCongTac");
        float chieuCao = Float.parseFloat(request.getParameter("chieuCao"));
        float canNang = Float.parseFloat(request.getParameter("canNang"));
        String nangKieuKhac = request.getParameter("nangKieuKhac");
        String anhCaNhan = request.getParameter("anhCaNhan");
        TinhThanh daiDienTinhThanh = quanLyTinhThanh.findById(Long.parseLong(request.getParameter("daiDienTinhThanh")));

        long id;
        if(chieuCao<0||canNang<0) id=Long.parseLong(""); else id = getId(request);

        return new ThiSinh(id, ten, ngaySinh, diaChiCuTru, sdt, email, cmt, ngheNghiep, trinhDoVH, danToc,
                donViCongTac, chieuCao, canNang, nangKieuKhac, anhCaNhan, daiDienTinhThanh);
    }

    private long getId(HttpServletRequest request) {
        long id;
        String strID = request.getParameter("id");
        if (strID.equals("")) {
            id = QuanLyThiSinhImpl.idThiSinh + 1;
        } else {
            id = Long.parseLong(strID);
        }
        return id;
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        ThiSinh thiSinh = quanLyThiSinh.findById(id);
        RequestDispatcher dispatcher;
        List<TinhThanh> listTinhThanh = quanLyTinhThanh.getAll();
        request.setAttribute("listTinhThanh", listTinhThanh);
        request.setAttribute("thiSinh", thiSinh);
        dispatcher = request.getRequestDispatcher("add-edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteThiSinh(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        quanLyThiSinh.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showlistDaDuyet(HttpServletRequest request, HttpServletResponse response) {

        List<ThiSinh> listDaDuyet = quanLyThiSinh.daDuyet();

        request.setAttribute("listDaDuyet", listDaDuyet);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listDaDuyet.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        ThiSinh thiSinh = quanLyThiSinh.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");

        try {
            request.setAttribute("thiSinh", thiSinh);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
