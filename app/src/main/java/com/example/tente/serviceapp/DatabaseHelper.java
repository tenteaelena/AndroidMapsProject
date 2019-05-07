package com.example.tente.serviceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tente on 1/29/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME ="gpsdata.db";
    public static final String TABLE1_NAME = "collected_gps_data";
    public static final String TABLE2_NAME = "gps_locations";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table collected_gps_data (ID INTEGER PRIMARY " +
                "KEY AUTOINCREMENT, LATITUDE TEXT, LONGITUDE TEXT, TIMESTAMP DATA, " +
                "ACCELERATION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE1_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertCollectedData(String tableName, ArrayList content){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("LATITUDE",(String)content.get(0));//latitudinea
        cv.put("LONGITUDE",(String)content.get(1));//longitudinea
        cv.put("TIMESTAMP",(String)content.get(2));//data
        cv.put("ACCELERATION",(String)content.get(3));//acceleratia
        long result = sqLiteDatabase.insert(tableName,null,cv);
        Log.d("TEST","database helper");
        if(result==-1) return false;
            else return true;
    }



    public Cursor getAllData(String table){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM "+table, null);
        return  res;
    }
}
