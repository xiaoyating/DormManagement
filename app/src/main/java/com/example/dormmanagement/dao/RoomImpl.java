package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomImpl implements RoomDao{
    private DBHelper helper;
    private SQLiteDatabase db;

    public RoomImpl(Context context){
        //调用MYBHelper类的构造方法时，如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与以有的不一致，则调用onUpgrade 方法更新
        helper =new DBHelper(context,1);
    }

    @Override
    public List<Room> selsetAllRooms() {
        List<Room> rooms=null;
        //1. 获取SQLiteDAtabase对象
        db=helper.getReadableDatabase();

        //2.查询
        String sql="select*from t_room";
        Cursor cursor=db.rawQuery(sql,null);//跟ResultSet
        //3.处理结果
        if (cursor!=null&&cursor.getCount()>0){
            rooms=new ArrayList<>();
            while (cursor.moveToNext()){
                Room room=new Room();
                room.setRoomName(cursor.getString(cursor.getColumnIndex("room_name")));
                room.setExpertNumber(cursor.getInt(cursor.getColumnIndex("expect_num")));
                rooms.add(room);
            }
            //4.cursor
            cursor.close();
        }

        //5.返回
        return rooms;
    }

    @Override
    public void insert(Room room) {
        //1.获取db对象
        db=helper.getWritableDatabase();
        String sql="insert into t_room values(null,?,?,?,?,?,?)";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                room.getRoomName(),
                room.getRoomSex(),
                room.getExpertNumber(),
                room.getRealNumber(),
                room.getCost(),
                room.getRemark()});

    }

    @Override
    public void update(Room room) {

        db=helper.getWritableDatabase();
        String sql="update  t_room set room_number=? where room_name=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                room.getRealNumber(),
                room.getRoomName()});
    }

    @Override
    public void delete(String roomName) {
        db=helper.getWritableDatabase();

        String sql="delete from t_room  where room_name=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{roomName});
    }
}
