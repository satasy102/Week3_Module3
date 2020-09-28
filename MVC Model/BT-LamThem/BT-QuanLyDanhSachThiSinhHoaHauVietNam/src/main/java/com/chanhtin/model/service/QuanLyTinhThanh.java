package com.chanhtin.model.service;

import com.chanhtin.model.model.TinhThanh;

import java.util.List;

public interface QuanLyTinhThanh {
    List<TinhThanh> getAll();

    void save(TinhThanh tinhThanh);

    void update(Long idTinh, TinhThanh tinhThanh);

    void delete(Long idTinh);

    TinhThanh findById(Long id);

}
