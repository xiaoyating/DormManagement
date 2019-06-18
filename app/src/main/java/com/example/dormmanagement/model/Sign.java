package com.example.dormmanagement.model;

import java.io.Serializable;

public class Sign implements Serializable {

    public static final String TBL_AD_SIGN = "create table if not exists t_ad_sign(" +
            "id integer primary key autoincrement, " +
            "ad_username varchar(20), " +
            "ad_password varchar(200))";
    private int id;
    private String username;
    private String password;

    public Sign(){

    }

    public Sign(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static String getTblSign() {
        return TBL_AD_SIGN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
