package com.zq.staffmanageproject.service;

import com.zq.staffmanageproject.entity.Salesman;
import com.zq.staffmanageproject.mapper.SalesmanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {
    @Autowired
    SalesmanMapper salesmanMapper;

    public Salesman getSalesmanById(int id){
        return salesmanMapper.getSalesmanById(id);
    }

    public List<Salesman> getSalesmanByName(String name) {
        return salesmanMapper.getSalesmanByName(name);
    }

    public List<Salesman> getAll() {
        return salesmanMapper.getAll();
    }

    public Salesman insertSalesman(Salesman s) {
        salesmanMapper.insertSalesmanToStaff(s);
        salesmanMapper.insertSalesmanToSalesman(s);
        return s;
    }

    public void updateSalesman(Salesman s) {
        switch (s.getLevel()) {
            case Salesman -> {
                salesmanMapper.updateSalesman(s);
            }
            case Technician -> {
                salesmanMapper.updateSalesmanToTechnician(s);
            }
            case Manager -> {
                salesmanMapper.updateSalesmanToManager(s);
            }
        }
    }

    public void deleteSalesmanById(int id) {
        salesmanMapper.deleteSalesmanById(id);
    }
}
