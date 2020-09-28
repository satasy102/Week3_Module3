package com.chanhtin.model.model;

public class TinhThanh {
    private Long idTinh;
    private String tenTinh;

    public TinhThanh(Long idTinh, String tenTinh) {
        this.idTinh = idTinh;
        this.tenTinh = tenTinh;
    }

    public Long getIdTinh() {
        return idTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }
}
