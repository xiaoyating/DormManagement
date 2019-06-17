package com.example.dormmanagement.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;

import static com.example.dormmanagement.model.Room.TBL_ROOM;

//add unisi
public class DBHelper extends SQLiteOpenHelper {
    public final String TBL_STUDENT="create table student(" +
            "id integer primary key not null," +
            "s_number varchar not null," +
            "s_name varchar(6) not null," +
            "major text not null," +
            "age integer not null," +
            "sex varchar default'女'," +
            "room_number integer not null ," +
            "storey integer  not null) ";

    public DBHelper(Context context) {
        super(context, "demo.db", null, 2);
    }
//1.当app发现没有demo.db时会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_STUDENT);
        db.execSQL(TBL_ROOM);


    }
//当app发现有demo.db时，安且version有变化时会自动调用unUpgrade更新数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists student");
        db.execSQL("drop table if exists room");
     onCreate(db);
    }
}
