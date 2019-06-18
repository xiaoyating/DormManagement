package com.example.dormmanagement.model;

import java.io.Serializable;

public class Room implements Serializable {
    public static final String TBL_ROOM="create table room("+
            "id integer primary key autoincrement not null,"+
            "roomnumber varchar(20) not null,"+
            "staynumber integer not null," +
            "residentnumber integer not null,"+
            "monery integer not null)";


   private int id;
   private String roomnumber;
   private int staynumber;
   private int residentnumber;
   private int monery;

    public  Room(){

    }

    public Room(int id, String roomnumber, int staynumber, int residentnumber, int monery) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.staynumber = staynumber;
        this.residentnumber = residentnumber;
        this.monery = monery;
    }

    public static String getTblRoom() {
        return TBL_ROOM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getStaynumber() {
        return staynumber;
    }

    public void setStaynumber(int staynumber) {
        this.staynumber = staynumber;
    }

    public int getResidentnumber() {
        return residentnumber;
    }

    public void setResidentnumber(int residentnumber) {
        this.residentnumber = residentnumber;
    }

    public int getMonery() {
        return monery;
    }

    public void setMonery(int monery) {
        this.monery = monery;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomnumber='" + roomnumber + '\'' +
                ", staynumber=" + staynumber +
                ", residentnumber=" + residentnumber +
                ", monery=" + monery +
                '}';
    }
}
