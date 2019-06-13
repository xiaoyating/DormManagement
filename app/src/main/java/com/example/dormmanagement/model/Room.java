package com.example.dormmanagement.model;

public class Room{
   private int id;
   private String roomName;
   private String roomSex;
   private int expertNumber;
   private int realNumber;
   private int cost;
   private String remark;

   public Room(){

   }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomSex() {
        return roomSex;
    }

    public void setRoomSex(String roomSex) {
        this.roomSex = roomSex;
    }

    public int getExpertNumber() {
        return expertNumber;
    }

    public void setExpertNumber(int expertNumber) {
        this.expertNumber = expertNumber;
    }

    public int getRealNumber() {
        return realNumber;
    }

    public void setRealNumber(int realNumber) {
        this.realNumber = realNumber;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", roomSex='" + roomSex + '\'' +
                ", expertNumber=" + expertNumber +
                ", realNumber=" + realNumber +
                ", cost=" + cost +
                ", remark='" + remark + '\'' +
                '}';
    }
}
