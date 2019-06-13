package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanagement.model.Room;

import java.util.Currency;
import java.util.List;

public class RoomImpl implements RoomDao{
    private MyDBHelper helper;
    private SQLiteDatabase db;

    public RoomImpl(Context context){
        //调用MYBHelper类的构造方法时，如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与以有的不一致，则调用onUpgrade 方法更新
        helper =new MyDBHelper(context,1);
    }

    @Override
    public List<Room> selsetAllRooms() {
        List<Room> rooms=null;
        //1. 获取SQLiteDAtabase对象
        db=helper.getReadableDatabase();

        //2.查询
        String sql="select*from t_room";
        Cursor cursor=db.rawQuery(sql,null);
        //3.处理结果

        //4.返回
        return rooms;
    }

    @Override
    public void insert(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(String roomName) {

    }
}
