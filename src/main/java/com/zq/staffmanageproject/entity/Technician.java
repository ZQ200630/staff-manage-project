package com.zq.staffmanageproject.entity;

public class Technician extends Staff {
    private int hours;

    public Technician(int id, String name, int age, Level level, int hours, String password) {
        super(id, name, age, level, hours * 100, password);
        this.hours = hours;
    }

    public Technician(String name, int age, Level level, int hours, String password) {
        super(name, age, level, hours * 100, password);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
        this.setSalary(this.hours * 100);
    }

    public Technician() {
    }
}
