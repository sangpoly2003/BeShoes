package com.sang.beshoes.dao;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sang.beshoes.database.Dbhelper;
import com.sang.beshoes.mode.loaiGiayMode;

import java.util.ArrayList;

public class loaiGiayDAO {
       Dbhelper dbhelper;

    public loaiGiayDAO(Context context) {
        this.dbhelper = new Dbhelper(context);
    }

    public  ArrayList<loaiGiayMode> getListloaigiay(){
        ArrayList<loaiGiayMode> list = new ArrayList<>();
        SQLiteDatabase database = dbhelper.getReadableDatabase();
        database.beginTransaction();

        try {
            Cursor cursor = database.rawQuery("select * from LoaiGiay",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                do {
                    list.add( new loaiGiayMode(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)));
                }while (cursor.moveToNext());
                    database.setTransactionSuccessful();
            }
        }catch (Exception e){
            Log.e(TAG , "getListloaigiay"+e.getMessage());
        }finally {
               database.endTransaction();
        }
        return list;
    }


    public boolean addLoaiSach(loaiGiayMode loaigiay) {

        SQLiteDatabase database = dbhelper.getWritableDatabase();
        database.beginTransaction();

        ContentValues values = new ContentValues();
        values.put("tenLoai", loaigiay.getTenLoai());
        values.put("trangThai", loaigiay.getTrangThai());
        database.setTransactionSuccessful();
        database.endTransaction();

        long check = database.insert("LoaiGiay", null, values);

        return check != -1;
    }


    public boolean removeLoaiSach(int id){
        SQLiteDatabase sqLiteDatabase =dbhelper.getWritableDatabase();
        int row = sqLiteDatabase.delete("LoaiGiay", "maLG = ?", new String[]{String.valueOf(id)});
        return  row!=-1;
    }

    public  boolean updateLoaiSach ( loaiGiayMode loaigiay ){
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenLoai", loaigiay.getTenLoai());
        values.put("trangThai", loaigiay.getTrangThai());

        int check = database.update("LoaiGiay", values, "maLG = ?", new String[]{String.valueOf(loaigiay.getId())});
        return  check!=-1;
    }

}
