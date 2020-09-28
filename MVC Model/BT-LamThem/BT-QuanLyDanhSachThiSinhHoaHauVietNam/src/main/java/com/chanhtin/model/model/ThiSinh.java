package com.chanhtin.model.model;

public class ThiSinh {
    private final Long id;
    private String hoTen;
    private String ngaySinh;
    private String diaChiCuTru;
    private String sdt;
    private String email;
    private String cmt;
    private String ngheNghiep;
    private String trinhDoVanHoa;
    private String danToc;
    private String donViCongTac;
    private int chieuCao;
    private int canNang;
    private String nangKieuKhac;
    private String anhCaNhan;
    private TinhThanh daiDienTinhThanh;
    private boolean duyet=false;

    public ThiSinh(Long id, String hoTen, String ngaySinh, String diaChiCuTru, String sdt, String email, String cmt, String ngheNghiep,
                   String trinhDoVanHoa, String danToc, String donViCongTac, int chieuCao, int canNang,
                   String nangKieuKhac, String anhCaNhan, TinhThanh daiDienTinhThanh) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh=ngaySinh;
        this.diaChiCuTru = diaChiCuTru;
        this.sdt = sdt;
        this.email = email;
        this.cmt = cmt;
        this.ngheNghiep = ngheNghiep;
        this.trinhDoVanHoa = trinhDoVanHoa;
        this.danToc = danToc;
        this.donViCongTac = donViCongTac;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nangKieuKhac = nangKieuKhac;
        this.anhCaNhan = anhCaNhan;
        this.daiDienTinhThanh = daiDienTinhThanh;
    }

    public Long getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChiCuTru() {
        return diaChiCuTru;
    }

    public void setDiaChiCuTru(String diaChiCuTru) {
        this.diaChiCuTru = diaChiCuTru;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getTrinhDoVanHoa() {
        return trinhDoVanHoa;
    }

    public void setTrinhDoVanHoa(String trinhDoVanHoa) {
        this.trinhDoVanHoa = trinhDoVanHoa;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getDonViCongTac() {
        return donViCongTac;
    }

    public void setDonViCongTac(String donViCongTac) {
        this.donViCongTac = donViCongTac;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    public String getNangKieuKhac() {
        return nangKieuKhac;
    }

    public void setNangKieuKhac(String nangKieuKhac) {
        this.nangKieuKhac = nangKieuKhac;
    }

    public String getAnhCaNhan() {
        return anhCaNhan;
    }

    public void setAnhCaNhan(String anhCaNhan) {
        this.anhCaNhan = anhCaNhan;
    }

    public TinhThanh getDaiDienTinhThanh() {
        return daiDienTinhThanh;
    }

    public void setDaiDienTinhThanh(TinhThanh daiDienTinhThanh) {
        this.daiDienTinhThanh = daiDienTinhThanh;
    }

    public boolean isDuyet() {
        return duyet;
    }

    public void setDuyet(boolean duyet){
        this.duyet =duyet;
    }
}
