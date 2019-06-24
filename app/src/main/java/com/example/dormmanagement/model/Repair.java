package com.example.dormmanagement.model;

import java.io.Serializable;

public class Repair implements Serializable {
    public static final String TBL_REPAIR="create table repair(" +
            "id integer primary key autoincrement not null,"+
            "rt_name integer(10)  not null," +
            "rt_namenumber varchar (20) not null," +
            "rt_problem varchar (100) not null," +
            "rt_ponenumber integer(15) not null" +
            ")";



    private int id;
    private String rt_namei;
    private int rt_namenumber;
    private String rt_problem;
    private int rt_ponenumber;


    public Repair() {
    }

    public static String getTblRepair() {
        return TBL_REPAIR;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRt_name() {
        return rt_namei;
    }

    public void setRt_namei(String rt_name) {
        this.rt_namei = rt_name;
    }

    public int getRt_namenumber() {
        return rt_namenumber;
    }

    public void setRt_namenumber(Integer rt_namenumber) {
        this.rt_namenumber = rt_namenumber;
    }

    public String getRt_problem() {
        return rt_problem;
    }

    public void setRt_problem(String rt_problem) {
        this.rt_problem = rt_problem;
    }

    public int getRt_ponenumber() {
        return rt_ponenumber;
    }

    public void setRt_ponenumber(int rt_ponenumber) {
        this.rt_ponenumber = rt_ponenumber;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", rt_name='" + rt_namei + '\'' +
                ", rt_namenumber='" + rt_namenumber + '\'' +
                ", rt_problem='" + rt_problem + '\'' +
                ", rt_ponenumber=" + rt_ponenumber +
                '}';
    }

    public Repair(int id, String rt_name, int rt_namenumber, String rt_problem, int rt_ponenumber, String rt_date) {
        this.id = id;
        this.rt_namei = rt_name;
        this.rt_namenumber = rt_namenumber;
        this.rt_problem = rt_problem;
        this.rt_ponenumber = rt_ponenumber;


    }

    public String rt_name() {
        return null;
    }


}
