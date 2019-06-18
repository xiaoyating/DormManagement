package com.example.dormmanagement.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Sign;
import com.example.dormmanagement.model.Student;

//add unisi
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, int version) {
        super(context, "demo.db", null, version);
    }
//1.当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Student.TBL_STUDENT);
        db.execSQL(Room.TBL_ROOM);
        db.execSQL(Sign.TBL_AD_SIGN);

    }
//当app发现有demo.db时，安且version有变化时会自动调用unUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists student");
     db.execSQL("drop table if exists room");
        db.execSQL("drop table if exists t_ad_sign");
     onCreate(db);
    }
}
