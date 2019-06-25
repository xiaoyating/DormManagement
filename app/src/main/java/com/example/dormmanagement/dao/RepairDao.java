package com.example.dormmanagement.dao;

import com.example.dormmanagement.model.Repair;
import com.example.dormmanagement.model.Room;

import java.util.List;

public interface RepairDao {

    List<Repair> selsetRepair();
    Repair select(String name);
    List<Repair> selectNameNumber();

    //增删改
    void insert(Repair repair);
    void update(Repair repair);
    void delete(String name);
}
