package com.example.dormmanagement.dao;

import com.example.dormmanagement.model.Sign;

import java.util.List;

public interface SignDao  {
    List<Sign> selectAllUsernames();

    //条件查询
//    Room select(String roomName);
//    List<Room> selectByCost(int cost);

    Sign select(String userName);
    //添删改一个宿舍
    void insert(Sign sign);
    void update(Sign sign);
    void delete(String sign);
}