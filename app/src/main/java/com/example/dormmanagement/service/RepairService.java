package com.example.dormmanagement.service;

import com.example.dormmanagement.model.Repair;
import com.example.dormmanagement.model.Room;

import java.util.List;

public interface RepairService {
    public List<Repair> getRepair();
    public void insert(Repair repair);
    public void modifyRepair(Repair repair);
    public void delete(String name);
}
