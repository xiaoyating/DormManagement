package com.example.dormmanagement.service;

import android.content.Context;

import com.example.dormmanagement.dao.RoomDao;
import com.example.dormmanagement.dao.RoomDaoImpl;
import com.example.dormmanagement.model.Room;

import java.util.List;

public class RoomServiceImpl implements RoomService{
    private RoomDao roomDao;

    public RoomServiceImpl(Context context){
        roomDao=new RoomDaoImpl(context);
    }

    public List<Room> getAllrooms() {
        return roomDao.selsetAllRooms();
    }


    public void insert(Room room) {
        roomDao.insert(room);
    }

    @Override
    public void modifyRealNumber(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(String roomNumber) {
        roomDao.delete(roomNumber);
    }
}
