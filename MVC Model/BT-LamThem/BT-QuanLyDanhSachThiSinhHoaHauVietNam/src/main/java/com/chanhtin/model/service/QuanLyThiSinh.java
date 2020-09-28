package com.chanhtin.model.service;

import com.chanhtin.model.model.ThiSinh;
import com.chanhtin.model.model.TinhThanh;

import java.util.List;

public interface QuanLyThiSinh {

    List<ThiSinh> getAll();

    void save(ThiSinh thiSinh);

    void update(Long id, ThiSinh thiSinh);

    void delete(Long id);

    ThiSinh findById(Long id);

    List<ThiSinh> findByName(String ten);

    List<ThiSinh> findByTinhThanh(TinhThanh tinhThanh);

    List<ThiSinh> daDuyet();
}
