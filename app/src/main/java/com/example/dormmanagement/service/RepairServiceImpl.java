package com.example.dormmanagement.service;

import android.content.Context;

import com.example.dormmanagement.activity.RepairActivity;
import com.example.dormmanagement.dao.RepairDao;
import com.example.dormmanagement.dao.RepairDaoImpl;
import com.example.dormmanagement.model.Repair;

import java.util.List;

public class RepairServiceImpl implements RepairService{
    private RepairDao repairDao;



    public RepairServiceImpl(Context context) {
        repairDao = new RepairDaoImpl(context);
    }

    public RepairServiceImpl(RepairActivity repairActivity) {
        repairDao=new RepairDaoImpl(repairActivity);
    }


    @Override
    public List<Repair> getRepair() {
        return repairDao.selsetRepair();
    }


    @Override
    public void insert(Repair repair) {
     repairDao.insert(repair);
    }

    @Override
    public void modifyRepair(Repair repair) {
    repairDao.update(repair);
    }

    @Override
    public void delete(String roonName) {
        repairDao.delete(roonName);

    }
}
