package com.chanhtin.model.service;

import com.chanhtin.model.model.ThiSinh;
import com.chanhtin.model.model.TinhThanh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanLyThiSinhImpl implements QuanLyThiSinh{
    private static Map<Long, ThiSinh> danhSachThiSinh=new HashMap<>();
    public static int idThiSinh=2;

    static {
        QuanLyTinhThanhIpml quanLyTinhThanhIpml=new QuanLyTinhThanhIpml();
        TinhThanh hue= quanLyTinhThanhIpml.findById(56L);

        ThiSinh tin=new ThiSinh(1L,"Do Chanh Tin", "7/4/1995",
                "25 Nguyen Duy Trinh, tp Hue","0966257540","dochanhtin07041995@gmail.com",
                "123456789","Lap trinh vien","dai hoc","Kinh",
                "Code Gym Hue",175,60,"Ca hat",
                "https://znews-photo.zadn.vn/w1024/Uploaded/neg_yslewlx/2020_09_26/PHAM_THI_PHUONG_QUYNH.jpg",hue);


        ThiSinh nguyen=new ThiSinh(2L,"Duong Do Nguyen", "10/4/1995",
                "25 Nguyen Hue, tp Hue","0966257540","dochanhtin7495@gmail.com",
                "123456789","Lap trinh vien","dai hoc","Kinh",
                "Code Gym Hue",185,60,"Ca hat",
                "https://znews-photo.zadn.vn/w1024/Uploaded/neg_yslewlx/2020_09_26/PHAM_THI_PHUONG_QUYNH.jpg",hue);

        danhSachThiSinh.put(1L,tin);

        danhSachThiSinh.put(2L,nguyen);
    }
    @Override
    public List<ThiSinh> getAll() {
        return new ArrayList<ThiSinh>(danhSachThiSinh.values());
    }

    @Override
    public void save(ThiSinh thiSinh) {
        ++idThiSinh;
        danhSachThiSinh.put(thiSinh.getId(), thiSinh);
    }

    @Override
    public void update(Long id, ThiSinh thiSinh) {
        danhSachThiSinh.put(id, thiSinh);
    }

    @Override
    public void delete(Long id) {
        ThiSinh thiSinh= findById(id);
            if (!thiSinh.isDuyet())
                danhSachThiSinh.remove(id);
    }

    @Override
    public ThiSinh findById(Long id) {
        if(danhSachThiSinh.containsKey(id))
        return danhSachThiSinh.get(id);
        return null;
    }

    @Override
    public List<ThiSinh> findByName(String ten) {
        List<ThiSinh> listThiSinh=new ArrayList<>();
        for (ThiSinh thiSinh:danhSachThiSinh.values()){
            if (thiSinh.getHoTen().contains(ten))
                listThiSinh.add(thiSinh);
        }
        return listThiSinh;
    }

    @Override
    public List<ThiSinh> findByTinhThanh(TinhThanh tinhThanh) {
        List<ThiSinh> listThiSinh=new ArrayList<>();
        for (ThiSinh thiSinh:danhSachThiSinh.values()){
            if (thiSinh.getDaiDienTinhThanh().equals(tinhThanh))
                listThiSinh.add(thiSinh);
        }
        return listThiSinh;
    }

    @Override
    public List<ThiSinh> daDuyet() {
        List<ThiSinh> listThiSinh=new ArrayList<>();
        for (ThiSinh thiSinh:danhSachThiSinh.values()){
            if (thiSinh.isDuyet())
                listThiSinh.add(thiSinh);
        }
        return listThiSinh;
    }
}
