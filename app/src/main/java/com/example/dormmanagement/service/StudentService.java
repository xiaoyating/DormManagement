package com.example.dormmanagement.service;

import android.content.Context;

import com.example.dormmanagement.dao.StudentDao;
import com.example.dormmanagement.dao.StudentDaoImpl;
import com.example.dormmanagement.model.Student;

import java.util.ConcurrentModificationException;

public class StudentService {
    private StudentDao dao;

    public StudentService(Context context) {
        dao = new StudentDaoImpl(context);
    }

    public void insert(Student student) {
        if(student != null) {
            dao.insert(student);
        }
    }

}
