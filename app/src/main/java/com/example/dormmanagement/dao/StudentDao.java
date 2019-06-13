package com.example.dormmanagement.dao;

import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;

import java.util.List;

public interface StudentDao {
    //查询所有的宿舍
    List<Student> selsetAllStudent();
    //条件查询

//    Student select(String name);


    //增删改一个宿舍
    void insert(Student student);
    void update(Student student);
    void delete(String name);

}
