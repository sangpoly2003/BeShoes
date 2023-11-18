package com.sang.beshoes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {
    public Dbhelper( Context context) {
        super(context, "beshoes", null, 6);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String user = "create table User(username text primary key, password text,email text, chucVu INTEGER)";
        db.execSQL(user);
        String dataUser = "insert into User values('admin','admin','admin@gmail.com',0) ";
        db.execSQL(dataUser);
        String nhanVien = "create table NhanVien(maNV integer primary key AUTOINCREMENT, hoTen text ,ngaySinh date, gioiTinh text, sdt integer, ngayLam date, chucVu text)";
        db.execSQL(nhanVien);
        String khachHang = "create table KhachHang(maKH integer primary key AUTOINCREMENT, hoTen text ,ngaySinh date, gioiTinh text, sdt integer, email text)";
        db.execSQL(khachHang);
        String loaiGiay = "create table LoaiGiay(maLG integer primary key AUTOINCREMENT, tenLoai text, trangThai INTEGER DEFAULT 0 )";
        db.execSQL(loaiGiay);
        db.execSQL("INSERT INTO LoaiGiay VALUES(1,'Thượng đình',0),(2,'Tiếng anh',1),(3,'Lập trình',0)");
        String giay = "create table Giay(maGiay integer primary key AUTOINCREMENT, tenGiay text, imgGiay text, gia integer, maLG integer, soLuong integer, size integer, trangThai INTEGER DEFAULT 0)";
        db.execSQL(giay);
        String hoaDon = "create table HoaDon(maHD integer primary key AUTOINCREMENT, maKH integer ,maGiay integer, gia integer, ngay date, trangThai integer)";
        db.execSQL(hoaDon);
        String congViec = "create table CongViec(maCV integer primary key AUTOINCREMENT, maNV integer ,congViec text, ca text, trangThai int)";
        db.execSQL(congViec);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion , int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS User");
            db.execSQL("DROP TABLE IF EXISTS NhanVien");
            db.execSQL("DROP TABLE IF EXISTS KhachHang");
            db.execSQL("DROP TABLE IF EXISTS LoaiGiay");
            db.execSQL("DROP TABLE IF EXISTS Giay");
            db.execSQL("DROP TABLE IF EXISTS HoaDon");
            db.execSQL("DROP TABLE IF EXISTS CongViec");
            onCreate(db);
        }
    }
}

