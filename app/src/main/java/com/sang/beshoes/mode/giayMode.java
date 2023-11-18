package com.sang.beshoes.mode;

public class giayMode {
    //(maGiay integer primary key AUTOINCREMENT, tenGiay text, imgGiay text, gia integer, maLG integer, soLuong integer, size integer)";
    private int magiay,soluong,gia,maLG;
    private String tengiay,imggiay,size;

    public giayMode(int magiay, int soluong, int gia, int maLG, String tengiay, String imggiay, String size) {
        this.magiay = magiay;
        this.soluong = soluong;
        this.gia = gia;
        this.maLG = maLG;
        this.tengiay = tengiay;
        this.imggiay = imggiay;
        this.size = size;
    }

    public int getMagiay() {
        return magiay;
    }

    public void setMagiay(int magiay) {
        this.magiay = magiay;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getMaLG() {
        return maLG;
    }

    public void setMaLG(int maLG) {
        this.maLG = maLG;
    }

    public String getTengiay() {
        return tengiay;
    }

    public void setTengiay(String tengiay) {
        this.tengiay = tengiay;
    }

    public String getImggiay() {
        return imggiay;
    }

    public void setImggiay(String imggiay) {
        this.imggiay = imggiay;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
