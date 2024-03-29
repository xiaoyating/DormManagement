package com.example.dormmanagement.dao;

import android.view.View;

import com.example.dormmanagement.model.Room;

import java.util.List;

public interface RoomDao {
    //查询所有的宿舍
    List<Room> selsetAllRooms();
    //条件查询

//    Room select(String roomName);
//    List<Room> selectByCost(int cost);

    Room select(String roomName);

    List<Room> selectByNumber();

    //增删改一个宿舍
    void insert(Room room);
    void update(Room room);
    void delete(String roomName);

}
