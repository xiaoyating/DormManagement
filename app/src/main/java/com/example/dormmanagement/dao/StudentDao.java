package com.example.dormmanagement.dao;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selsetAllStudent();
    //条件查询

//    Student select(String name);



    void insert(Student student);
    void update(Student student);
    void delete(String name);

}
