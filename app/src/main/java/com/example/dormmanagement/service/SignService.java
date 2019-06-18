package com.example.dormmanagement.service;

import android.content.Context;

import com.example.dormmanagement.dao.SignDao;
import com.example.dormmanagement.dao.SignDaoImpl;
import com.example.dormmanagement.model.Sign;

public class SignService {
    private SignDao signDao;

    public SignService(Context context) {
        signDao = new SignDaoImpl(context);
    }



    //1.完成登录功能
    public boolean login(Sign sign) {
        Sign s = signDao.select(sign.getUsername());
        if(s != null && s.getPassword().equals(sign.getPassword())) {
            return true;
        }
        return  false;
    }
    //2.完成注册功能
    public boolean register(Sign sign) {
        Sign s=signDao.select(sign.getUsername());
        if (s==null){
            signDao.insert(sign);
            return true;
        }
        return false;
    }

}
