package com.chanhtin.model.service;

import com.chanhtin.model.model.TinhThanh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanLyTinhThanhIpml implements QuanLyTinhThanh{
    private static Map<Long, TinhThanh> danhSachTinhThanh=new HashMap<>();
    public static int count=63;
    static {
        danhSachTinhThanh.put(1L,new TinhThanh(1L,"An Giang"));
        danhSachTinhThanh.put(2L,new TinhThanh(2L,"Bà Rịa – Vũng Tàu"));
        danhSachTinhThanh.put(3L,new TinhThanh(3L,"Bắc Giang"));
        danhSachTinhThanh.put(4L,new TinhThanh(4L,"Bắc Kạn"));
        danhSachTinhThanh.put(5L,new TinhThanh(5L,"Bạc Liêu"));
        danhSachTinhThanh.put(6L,new TinhThanh(6L,"Bắc Ninh"));
        danhSachTinhThanh.put(7L,new TinhThanh(7L,"Bến Tre"));
        danhSachTinhThanh.put(8L,new TinhThanh(8L,"Bình Định"));
        danhSachTinhThanh.put(9L,new TinhThanh(9L,"Bình Dương"));
        danhSachTinhThanh.put(10L,new TinhThanh(10L,"Bình Phước"));
        danhSachTinhThanh.put(11L,new TinhThanh(11L,"Bình Thuận"));
        danhSachTinhThanh.put(12L,new TinhThanh(12L,"Cà Mau"));
        danhSachTinhThanh.put(13L,new TinhThanh(13L,"Cần Thơ"));
        danhSachTinhThanh.put(14L,new TinhThanh(14L,"Cao Bằng"));
        danhSachTinhThanh.put(15L,new TinhThanh(15L,"Đà Nẵng"));
        danhSachTinhThanh.put(16L,new TinhThanh(16L,"Đắk Lắk"));
        danhSachTinhThanh.put(17L,new TinhThanh(17L,"Đắk Nông"));
        danhSachTinhThanh.put(18L,new TinhThanh(18L,"Điện Biên"));
        danhSachTinhThanh.put(19L,new TinhThanh(19L,"Đồng Nai"));
        danhSachTinhThanh.put(20L,new TinhThanh(20L,"Đồng Tháp"));
        danhSachTinhThanh.put(21L,new TinhThanh(21L,"Gia Lai"));
        danhSachTinhThanh.put(22L,new TinhThanh(22L,"Hà Giang"));
        danhSachTinhThanh.put(23L,new TinhThanh(23L,"Hà Nam"));
        danhSachTinhThanh.put(24L,new TinhThanh(24L,"Hà Nội"));
        danhSachTinhThanh.put(25L,new TinhThanh(25L,"Hà Tĩnh"));
        danhSachTinhThanh.put(26L,new TinhThanh(26L,"Hải Dương"));
        danhSachTinhThanh.put(27L,new TinhThanh(27L,"Hải Phòng"));
        danhSachTinhThanh.put(28L,new TinhThanh(28L,"Hậu Giang"));
        danhSachTinhThanh.put(29L,new TinhThanh(29L,"Hòa Bình"));
        danhSachTinhThanh.put(30L,new TinhThanh(30L,"Hưng Yên"));
        danhSachTinhThanh.put(31L,new TinhThanh(31L,"Khánh Hòa"));
        danhSachTinhThanh.put(32L,new TinhThanh(32L,"Kiên Giang"));
        danhSachTinhThanh.put(33L,new TinhThanh(33L,"Kon Tum"));
        danhSachTinhThanh.put(34L,new TinhThanh(34L,"Lai Châu"));
        danhSachTinhThanh.put(35L,new TinhThanh(35L,"Lâm Đồng"));
        danhSachTinhThanh.put(36L,new TinhThanh(36L,"Lạng Sơn"));
        danhSachTinhThanh.put(37L,new TinhThanh(37L,"Lào Cai"));
        danhSachTinhThanh.put(38L,new TinhThanh(38L,"Long An"));
        danhSachTinhThanh.put(39L,new TinhThanh(39L,"Nam Định"));
        danhSachTinhThanh.put(40L,new TinhThanh(40L,"Nghệ An"));
        danhSachTinhThanh.put(41L,new TinhThanh(41L,"Ninh Bình"));
        danhSachTinhThanh.put(42L,new TinhThanh(42L,"Ninh Thuận"));
        danhSachTinhThanh.put(43L,new TinhThanh(43L,"Phú Thọ"));
        danhSachTinhThanh.put(44L,new TinhThanh(44L,"Phú Yên"));
        danhSachTinhThanh.put(45L,new TinhThanh(45L,"Quảng Bình"));
        danhSachTinhThanh.put(46L,new TinhThanh(46L,"Quảng Nam"));
        danhSachTinhThanh.put(47L,new TinhThanh(47L,"Quảng Ngãi"));
        danhSachTinhThanh.put(48L,new TinhThanh(48L,"Quảng Ninh"));
        danhSachTinhThanh.put(49L,new TinhThanh(49L,"Quảng Trị"));
        danhSachTinhThanh.put(50L,new TinhThanh(50L,"Sóc Trăng"));
        danhSachTinhThanh.put(51L,new TinhThanh(51L,"Sơn La"));
        danhSachTinhThanh.put(52L,new TinhThanh(52L,"Tây Ninh"));
        danhSachTinhThanh.put(53L,new TinhThanh(53L,"Thái Bình"));
        danhSachTinhThanh.put(54L,new TinhThanh(54L,"Thái Nguyên"));
        danhSachTinhThanh.put(55L,new TinhThanh(55L,"Thanh Hóa"));
        danhSachTinhThanh.put(56L,new TinhThanh(56L,"Thừa Thiên Huế"));
        danhSachTinhThanh.put(57L,new TinhThanh(57L,"Tiền Giang"));
        danhSachTinhThanh.put(58L,new TinhThanh(58L,"Hồ Chí Minh"));
        danhSachTinhThanh.put(59L,new TinhThanh(59L,"Trà Vinh"));
        danhSachTinhThanh.put(60L,new TinhThanh(60L,"Tuyên Quang"));
        danhSachTinhThanh.put(61L,new TinhThanh(61L,"Vĩnh Long"));
        danhSachTinhThanh.put(62L,new TinhThanh(62L,"Vĩnh Phúc"));
        danhSachTinhThanh.put(63L,new TinhThanh(63L,"Yên Bái"));
    }


    @Override
    public List<TinhThanh> getAll() {
        return new ArrayList<>(danhSachTinhThanh.values());
    }

    @Override
    public void save(TinhThanh tinhThanh) {
        danhSachTinhThanh.put(tinhThanh.getIdTinh(), tinhThanh);
        ++count;
    }

    @Override
    public void update(Long idTinh, TinhThanh tinhThanh) {
        danhSachTinhThanh.put(idTinh, tinhThanh);
    }

    @Override
    public void delete(Long idTinh) {
        --count;
        danhSachTinhThanh.remove(idTinh);
    }

    @Override
    public TinhThanh findById(Long id) {
        return danhSachTinhThanh.get(id);
    }

}
