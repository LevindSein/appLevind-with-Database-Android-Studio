package com.example.levindmopro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperEx extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ex.db";
    public static final String TABLE_NAME = "profileEx_table";
    public static final String col_1 = "NAMA_MANTAN";
    public static final String col_2 = "ASAL";
    public static final String col_3 = "KEAHLIAN";
    public static final String col_4 = "FOTO_MANTAN";

    public DatabaseHelperEx(Context context ) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (NAMA_MANTAN TEXT PRIMARY KEY, ASAL TEXT, KEAHLIAN TEXT,FOTO_MANTAN INTEGER)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nama, String asal, String keahlian, int foto){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,nama);
        contentValues.put(col_2,asal);
        contentValues.put(col_3,keahlian);
        contentValues.put(col_4,foto);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return  true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }
}
