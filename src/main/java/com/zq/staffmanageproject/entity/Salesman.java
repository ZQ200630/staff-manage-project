package com.zq.staffmanageproject.entity;

public class Salesman extends Staff {
    private int monthlySales;

    public Salesman(int id, String name, int age, Level level, int monthlySales, String password) {
        super(id, name, age, level, monthlySales * 0.04, password);
        this.monthlySales = monthlySales;
    }

    public Salesman(String name, int age, Level level, int monthlySales, String password) {
        super(name, age, level, monthlySales * 0.04, password);
        this.monthlySales = monthlySales;
    }

    public Salesman() { }

    public int getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(int monthlySales) {
        this.monthlySales = monthlySales;
        this.setSalary(monthlySales * 0.04);
    }

}
