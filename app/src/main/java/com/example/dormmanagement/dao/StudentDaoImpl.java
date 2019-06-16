package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.dormmanagement.model.Student;
import com.example.dormmanagement.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private DBHelper helper;
    private SQLiteDatabase db;

    public StudentDaoImpl(Context context) {
        //调用MYBHelper类的构造方法时，如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与以有的不一致，则调用onUpgrade 方法更新
        helper = new DBHelper(context, 1);
    }

    @Override
    public List<Student> selsetAllStudent() {
        List<Student> students=null;
        //1. 获取SQLiteDAtabase对象
        db=helper.getReadableDatabase();

        //2.查询
        String sql="select*from st";
        Cursor cursor=db.rawQuery(sql,null);//跟ResultSet
        //3.处理结果
        if (cursor!=null&&cursor.getCount()>0){
            students=new ArrayList<>();
            while (cursor.moveToNext()){
                Student student=new Student();
                student.setMajor(cursor.getString(cursor.getColumnIndex("name")));
                student.setAge(cursor.getInt(cursor.getColumnIndex("Age")));
                students.add(student);
            }
            //4.cursor
            cursor.close();
        }

        //5.返回
        return students;
    }
    //添加
    @Override
    public void insert(Student student) {
    //1.获取db对象
        db=helper.getWritableDatabase();
        String sql="insert into student values(null,?,?,?,?,?,?,?)";
        //2.执行sql对象
        db.execSQL(sql,new Object[]{
                student.getnumber(),
                student.getname(),
                student.getMajor(),
                student.getAge(),
                student.getSex(),
                student.getRoomnumber(),
                student.getStorey(),
        });
        db.close();
    }
//修改
    @Override
    public void update(Student student) {
        db=helper.getWritableDatabase();
        String sql="update student set number=? where name=?";
        db.execSQL(sql,new Object[]{
                student.getnumber(),
                student.getname()});

    }
//删除
    @Override
    public void delete(String name) {
        db=helper.getWritableDatabase();
        String sql="delete from student where name=?";
        db.execSQL(sql,new Object[]{name});

    }
}
