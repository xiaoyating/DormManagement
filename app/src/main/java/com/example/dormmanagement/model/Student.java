package com.example.dormmanagement.model;

public class Student {
    private int id;
    private String number;
    private String name;
    private String major;
    private int age;
    private String sex;
    private int roomnumber;
    private int storey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public String getTBL_STUDENT() {
        return TBL_STUDENT;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", roomnumber=" + roomnumber +
                ", storey=" + storey +
                ", TBL_STUDENT='" + TBL_STUDENT + '\'' +
                '}';
    }

    private final String TBL_STUDENT="create table student(" +
            "id integer primary key not null," +
            "number varchar not null," +
            "name varchar(6) not null," +
            "major text not null," +
            "age integer not null," +
            "sex varchar default'女'," +
            "roomnumber integer not null ," +
            "storey integer  not null) ";
}

