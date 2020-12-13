package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.Salesman;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesmanMapper {
    Salesman getSalesmanById(int id);

    List<Salesman> getSalesmanByName(String name);

    List<Salesman> getAll();

    void insertSalesmanToStaff(Salesman s);
    void insertSalesmanToSalesman(Salesman s);
    void updateSalesman(Salesman s);

    void updateSalesmanToManager(Salesman s);
    void updateSalesmanToTechnician(Salesman s);

    void deleteSalesmanById(int id);
}
