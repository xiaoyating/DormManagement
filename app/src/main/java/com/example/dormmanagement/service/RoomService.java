package com.example.dormmanagement.service;

import com.example.dormmanagement.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> getAllrooms();
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(String roonName);

}

