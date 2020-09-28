package com.chanhtin.controller;

import com.chanhtin.model.model.ThiSinh;
import com.chanhtin.model.model.TinhThanh;
import com.chanhtin.model.service.QuanLyThiSinhImpl;
import com.chanhtin.model.service.QuanLyTinhThanhIpml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QuanLyThiSinhServlet",urlPatterns = "/")
public class QuanLyThiSinhServlet extends HttpServlet {
    QuanLyThiSinhImpl quanLyThiSinh=new QuanLyThiSinhImpl();
    QuanLyTinhThanhIpml quanLyTinhThanh=new QuanLyTinhThanhIpml();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action==null) action="";
        switch (action){
            case "create":
                createThiSinh(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action==null) action="";
        switch (action){
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

    private void listThiSinh(HttpServletRequest request, HttpServletResponse response) {

        List<ThiSinh> listThiSinh;

        try {
            Long id=Long.parseLong(request.getParameter("id"));

            ThiSinh thiSinh= quanLyThiSinh.findById(id);

            thiSinh.setDuyet(!thiSinh.isDuyet());
            quanLyThiSinh.update(thiSinh.getId(), thiSinh);

        } catch (NumberFormatException e) {
           listThiSinh = quanLyThiSinh.getAll();
        } finally {
            listThiSinh = quanLyThiSinh.getAll();
            request.setAttribute("listThiSinh", listThiSinh);

            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            try {
                dispatcher.forward(request, response);
                response.sendRedirect("/");
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<TinhThanh> listTinhThanh=quanLyTinhThanh.getAll();
        request.setAttribute("listTinhThanh",listTinhThanh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createThiSinh(HttpServletRequest request, HttpServletResponse response) {
        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiCuTru = request.getParameter("diaChiCuTru");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String cmt=request.getParameter("cmt");
        String ngheNghiep=request.getParameter("ngheNghiep");
        String trinhDoVH=request.getParameter("trinhDoVH");
        String danToc=request.getParameter("danToc");
        String donViCongTac=request.getParameter("donViCongTac");
        int chieuCao=Integer.parseInt(request.getParameter("chieuCao"));
        int canNang=Integer.parseInt(request.getParameter("canNang"));
        String nangKieuKhac=request.getParameter("nangKieuKhac");
        String anhCaNhan=request.getParameter("anhCaNhan");
        TinhThanh daiDienTinhThanh=quanLyTinhThanh.findById(Long.parseLong(request.getParameter("daiDienTinhThanh")));

        Long id=0L;
        String strID= request.getParameter("id");
        if(strID.equals("")) {
            id = Long.valueOf(QuanLyThiSinhImpl.idThiSinh + 1);
        } else {
            id=Long.parseLong(strID);
        }

        ThiSinh thiSinh = new ThiSinh(id, ten, ngaySinh, diaChiCuTru, sdt, email, cmt,ngheNghiep,trinhDoVH,danToc,
                donViCongTac,chieuCao,canNang,nangKieuKhac,anhCaNhan,daiDienTinhThanh);

        quanLyThiSinh.save(thiSinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-edit.jsp");
        List<TinhThanh> listTinhThanh=quanLyTinhThanh.getAll();
        request.setAttribute("listTinhThanh",listTinhThanh);
        request.setAttribute("message", "Thành công");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        ThiSinh thiSinh = quanLyThiSinh.findById(id);
        RequestDispatcher dispatcher;
        if(thiSinh == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            List<TinhThanh> listTinhThanh=quanLyTinhThanh.getAll();
            request.setAttribute("listTinhThanh",listTinhThanh);
            request.setAttribute("thiSinh", thiSinh);
            dispatcher = request.getRequestDispatcher("add-edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteThiSinh(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        ThiSinh thiSinh = quanLyThiSinh.findById(id);
        RequestDispatcher dispatcher;
        if(thiSinh == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            quanLyThiSinh.delete(id);
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showlistDaDuyet(HttpServletRequest request, HttpServletResponse response) {

        List<ThiSinh> listDaDuyet=quanLyThiSinh.daDuyet();

            request.setAttribute("listDaDuyet", listDaDuyet);

            RequestDispatcher dispatcher = request.getRequestDispatcher("listDaDuyet.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        ThiSinh thiSinh = quanLyThiSinh.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");

        try {
            request.setAttribute("thiSinh",thiSinh);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
