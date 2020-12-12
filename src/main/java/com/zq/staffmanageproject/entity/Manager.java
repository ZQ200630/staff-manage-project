package com.zq.staffmanageproject.entity;

public class Manager extends Staff {

    public Manager(int id, String name, int age, Level level, String passWord) {
        super(id, name, age, level, 8000, passWord);
    }

    public Manager(String name, int age, Level level, String passWord) {
        super(name, age, level, 8000, passWord);
    }

    public Manager() {
    }
}
