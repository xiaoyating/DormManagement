package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao{
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public RoomDaoImpl(Context context){
        //调用MYBHelper类的构造方法时，如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与以有的不一致，则调用onUpgrade 方法更新
        dbHelper =new DBHelper(context,1);
    }

    @Override
    public void insert(Room room) {
        //1.获取db对象
        db=dbHelper.getWritableDatabase();
        String sql="insert into room values(null,?,?,?,?)";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                room.getRoomnumber(),
                room.getStaynumber(),
                room.getResidentnumber(),
                room.getMonery()});
        db.close();
    }

    @Override
    public void update(Room room) {

        db=dbHelper.getWritableDatabase();
        String sql="update  room set roomnumber=? where staynumber=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                room.getRoomnumber(),
                room.getStaynumber()});
    }

    @Override
    public void delete(String roomName) {
        db=dbHelper.getWritableDatabase();

        String sql="delete from room  where roomname=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{roomName});
    }




    @Override
    public List<Room> selsetAllRooms() {
        String sql="select * from room";
        List<Room> rooms=null;

        //1. 获取SQLiteDAtabase对象
        db=dbHelper.getReadableDatabase();

        //2.查询

        Cursor cursor=db.rawQuery(sql,null);//跟ResultSet
        //3.处理结果
        if (cursor!=null&&cursor.getCount()>0){
            rooms=new ArrayList<>();
            while (cursor.moveToNext()){
                Room room=new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomnumber(cursor.getString(cursor.getColumnIndex("roomnumber")));
                room.setStaynumber(cursor.getInt(cursor.getColumnIndex("staynumber")));
                room.setResidentnumber(cursor.getInt(cursor.getColumnIndex("residentnumber")));
                room.setMonery(cursor.getInt(cursor.getColumnIndex("monery")));
                rooms.add(room);
            }
            //4.cursor
            cursor.close();
        }
        db.close();
        //5.返回
        return rooms;
    }

    @Override
    public Room select(String roomnumber) {
        String sql = "select * from room where roomnumber=?";
        Room room = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{roomnumber});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomnumber(cursor.getString(cursor.getColumnIndex("roomnumber")));
                room.setStaynumber(cursor.getInt(cursor.getColumnIndex("staynumber")));
                room.setResidentnumber(cursor.getInt(cursor.getColumnIndex("residentnumber")));
                room.setMonery(cursor.getInt(cursor.getColumnIndex("monery")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return room;
    }

    @Override
    public List<Room> selectByNumber() {
        String sql = "select * from room where roomnumber > staynumber";
        List<Room> rooms = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            rooms = new ArrayList<>();
            while (cursor.moveToNext()) {
                Room room = new Room();
                room.setId(cursor.getInt(cursor.getColumnIndex("id")));
                room.setRoomnumber(cursor.getString(cursor.getColumnIndex("roomnumber")));
                room.setStaynumber(Integer.parseInt(cursor.getString(cursor.getColumnIndex("staynumber"))));
                room.setResidentnumber(cursor.getInt(cursor.getColumnIndex("residentnumber")));
                room.setMonery(cursor.getInt(cursor.getColumnIndex("monery")));

                rooms.add(room);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return rooms;
    }

}
