package com.zq.staffmanageproject.entity;

public class StaffNumbers {
    private int ManagerNumber;
    private int SalesmanNumber;
    private int TechnicianNumber;

    public int getManagerNumber() {
        return ManagerNumber;
    }

    public void setManagerNumber(int managerNumber) {
        ManagerNumber = managerNumber;
    }

    public int getSalesmanNumber() {
        return SalesmanNumber;
    }

    public void setSalesmanNumber(int salesmanNumber) {
        SalesmanNumber = salesmanNumber;
    }

    public int getTechnicianNumber() {
        return TechnicianNumber;
    }

    public void setTechnicianNumber(int technicianNumber) {
        TechnicianNumber = technicianNumber;
    }

    public StaffNumbers(int managerNumber, int salesmanNumber, int technicianNumber) {
        ManagerNumber = managerNumber;
        SalesmanNumber = salesmanNumber;
        TechnicianNumber = technicianNumber;
    }

    public StaffNumbers() {}
}
