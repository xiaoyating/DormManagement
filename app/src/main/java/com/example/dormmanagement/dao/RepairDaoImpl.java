package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanagement.model.Repair;
import com.example.dormmanagement.util.DBHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RepairDaoImpl implements RepairDao{

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public RepairDaoImpl(Context context){
        dbHelper =new DBHelper(context,4);
    }



    @Override
    public List<Repair> selsetRepair() {
        String sql="select * from repair";
        List<Repair> repairs=null;

        //1. 获取SQLiteDAtabase对象
        db=dbHelper.getReadableDatabase();

        //2.查询

        Cursor cursor=db.rawQuery(sql,null);//跟ResultSet
        //3.处理结果
        if (cursor!=null&&cursor.getCount()>0){
            repairs=new ArrayList<>();
            while (cursor.moveToNext()){
                Repair repair=new Repair();
                repair.setId(cursor.getInt(cursor.getColumnIndex("id")));
                repair.setRt_namei(cursor.getString(cursor.getColumnIndex("rt_mame")));
                repair.setRt_namenumber(cursor.getInt(cursor.getColumnIndex("rt_namenumber")));
                repair.setRt_problem(cursor.getString(cursor.getColumnIndex("rt_problem")));
                repair.setRt_ponenumber(cursor.getInt(cursor.getColumnIndex("rt_ponenumber")));
                repairs.add(repair);
            }
            //4.cursor
            cursor.close();
        }
        db.close();
        //5.返回
        return repairs;
    }

    @Override
    public Repair select(String name) {
        String sql = "select * from repair where rt_mame=?";
        Repair repair = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, new String[]{name});

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                repair = new Repair();
                repair.setId(cursor.getInt(cursor.getColumnIndex("id")));
                repair.setRt_namei(cursor.getString(cursor.getColumnIndex("rt_mame")));
                repair.setRt_namenumber(cursor.getInt(cursor.getColumnIndex("rt_namenumber")));
                repair.setRt_problem(cursor.getString(cursor.getColumnIndex("rt_problem")));
                repair.setRt_ponenumber(cursor.getInt(cursor.getColumnIndex("rt_ponenumber")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return repair;
    }

    @Override
    public List<Repair> selectNameNumber() {
        String sql = "select * from repair ";
        List<Repair> repairs = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            repairs = new ArrayList<>();
            while (cursor.moveToNext()) {
                Repair repair = new Repair();
                repair.setId(cursor.getInt(cursor.getColumnIndex("id")));
                repair.setRt_namei(cursor.getString(cursor.getColumnIndex("room_name")));
                repair.setRt_namenumber(cursor.getInt(cursor.getColumnIndex("rt_namenumber")));
                repair.setRt_problem(cursor.getString(cursor.getColumnIndex("rt_problem")));
                repair.setRt_ponenumber(cursor.getInt(cursor.getColumnIndex("rt_ponenumber")));
                repairs.add(repair);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return repairs;
    }


    @Override
    public void insert(Repair repair) {
        db=dbHelper.getWritableDatabase();
        String sql="insert into repair values(null,?,?,?,?)";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                repair.getRt_name(),
                repair.getRt_namenumber(),
                repair.getRt_problem(),
                repair.getRt_ponenumber()});
        db.close();
    }

    @Override
    public void update(Repair repair) {
        db=dbHelper.getWritableDatabase();
        String sql="update  repair set rt_name=? where rt_namenumber=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                repair.getRt_name(),
                repair.getRt_namenumber()});
    }

    @Override
    public void delete(String name) {
        db=dbHelper.getWritableDatabase();

        String sql="delete from repair  where rt_name=?";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{name});
    }
}
