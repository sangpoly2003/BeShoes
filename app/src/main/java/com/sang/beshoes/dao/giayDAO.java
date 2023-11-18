package com.sang.beshoes.dao;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sang.beshoes.database.Dbhelper;
import com.sang.beshoes.mode.giayMode;

import java.util.ArrayList;

public class giayDAO {
     Dbhelper dbhelper;
      public  giayDAO(Context context){
          dbhelper =  new Dbhelper(context);
      }
      public ArrayList<giayMode> getListGiay(){
         ArrayList<giayMode> list =  new ArrayList<>();
          SQLiteDatabase database =  dbhelper.getReadableDatabase();
          database.beginTransaction();
          try {
              Cursor cursor = database.rawQuery("select * from Giay", null);
              if (cursor.getCount() > 0){
                  cursor.moveToFirst();
                  do {
                      list.add(new giayMode(cursor.getInt(0),
                              cursor.getInt(1),
                              cursor.getInt(2),
                              cursor.getInt(3),
                              cursor.getString(4),
                              cursor.getString(5),
                              cursor.getString(6)
                      ));
                  }while (cursor.moveToNext());
                  database.setTransactionSuccessful();
          }

          }catch (Exception e) {
              Log.e(TAG ,"getListGiay"+e.getMessage() );

          }finally {
            database.endTransaction();
          }
          return list ;
//int magiay, int soluong, int gia, int maLG, String tengiay, String imggiay, String size
               }
    public boolean addLoaiSach(giayMode giayMODE) {

        SQLiteDatabase database = dbhelper.getWritableDatabase();
        database.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("tenGiay",giayMODE.getTengiay());
//        values.put("tenLoaiSach", giayMODE.getTenLoaiSach());
//        values.put("trangThai", giayMODE.getTrangThai());
        database.setTransactionSuccessful();
        database.endTransaction();
        long check = database.insert("Giay", null, values);

        return check != -1;
    }


    public boolean removeLoaiSach(int id){
        SQLiteDatabase sqLiteDatabase =dbhelper.getWritableDatabase();
        int row = sqLiteDatabase.delete("LoaiSach", "idLoaiSach = ?", new String[]{String.valueOf(id)});
        return  row!=-1;
    }

//    public  boolean updateLoaiSach ( giayMode giayModel ){
//        SQLiteDatabase database = dbhelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        values.put("tenLoaiSach", giayModel.getTengiay());
//        int check = database.update("LoaiSach", values, "idLoaiSach = ?", new String[]{String.valueOf(giayMode.g())});
//        return  check!=-1;
//    }


      }

