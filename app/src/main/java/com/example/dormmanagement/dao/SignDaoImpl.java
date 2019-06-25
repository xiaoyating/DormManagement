package com.example.dormmanagement.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanagement.model.Sign;
import com.example.dormmanagement.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class SignDaoImpl implements SignDao {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public SignDaoImpl(Context context){
        // 调用MyDBHelper类的构造方法时，
        // 若发现demo.db不存在会调用onCreate方法创建
        // 若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        dbHelper = new DBHelper(context,4);
    }

    @Override
    public List<Sign> selectAllUsernames() {
        String sql = "select * from t_ad_sign";
        List<Sign> signs = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            signs = new ArrayList<>();
            while (cursor.moveToNext()) {
                Sign sign = new Sign();

                sign.setId(cursor.getInt(cursor.getColumnIndex("id")));
                sign.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                sign.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                signs.add(sign);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return signs;
    }

    @Override
    public Sign select(String username) {
        Sign sign = null;
        db = dbHelper.getReadableDatabase();
        //2、查询
        String sql = "select * from t_ad_sign where ad_username=?";
        Cursor cursor = db.rawQuery( sql, new String[]{String.valueOf(username)} );//跟Result类似
        //3、处理结果
        if (cursor!=null&&cursor.getCount()>0) {
            if (cursor.moveToNext()) {
                sign = new Sign();
                sign.setUsername(cursor.getString(cursor.getColumnIndex("ad_username")));
                sign.setPassword(cursor.getString(cursor.getColumnIndex("ad_password")));
            }
            //关闭cursor
            cursor.close();
        }
        db.close();
        return sign;
    }

    @Override
    public void insert(Sign sign) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_ad_sign values(null,?,?)";
        db.execSQL(sql, new Object[]{
                sign.getUsername(),
                sign.getPassword()});
        db.close();
    }

    @Override
    public void update(Sign sign) {

    }

    @Override
    public void delete(String username) {

    }
}
