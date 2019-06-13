package com.example.dormmanagement.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;
//add unisi
public class DBHelper extends SQLiteOpenHelper {
    private final String TBL_STUDENT="create table student(" +
            "id integer primary key not null," +
            "s_number varchar not null," +
            "s_name varchar(6) not null," +
            "major text not null," +
            "age integer not null," +
            "sex varchar default'女'," +
            "room_number integer not null ," +
            "storey integer  not null) ";
    public DBHelper(Context context, int version) {
        super(context, "demo.db", null, version);
    }
//1.当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_STUDENT);

    }
//当app发现有demo.db时，安且version有变化时会自动调用unUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists student");
     onCreate(db);
    }
}
