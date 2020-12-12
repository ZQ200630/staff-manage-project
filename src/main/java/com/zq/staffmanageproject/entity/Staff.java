package com.zq.staffmanageproject.entity;

import java.util.Objects;

public class Staff {
    private int id;
    private String name;
    private int age;
    private Level level;
    private double salary;
    private String password;

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff(int id, String name, int age, Level level, double salary, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
        this.salary = salary;
        this.password = password;
    }

    public Staff(String name, int age, Level level, double salary, String password) {
        this.id = 0;
        this.name = name;
        this.age = age;
        this.level = level;
        this.salary = salary;
        this.password = password;
    }

    public Staff() {}

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Staff staff = (Staff) o;
        return id == staff.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
