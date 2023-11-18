package com.sang.beshoes.mode;

public class loaiGiayMode {
   // String loaiGiay = "create table LoaiGiay(maLG integer primary key AUTOINCREMENT, tenLoai text, trangThai INTEGER DEFAULT 0 )";
    private int id;
    private String tenLoai;
    private int trangThai;

    public loaiGiayMode() {
    }

    public loaiGiayMode(int id, String tenLoai, int trangThai) {
        this.id = id;
        this.tenLoai = tenLoai;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
