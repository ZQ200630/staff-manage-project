package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.Technician;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicianMapper {
    Technician getTechnicianById(int id);

    Technician getTechnicianByName(String name);

    List<Technician> getAll();

    void insertTechnicianToStaff(Technician t);
    void insertTechnicianToTechnician(Technician t);
    void updateTechnician(Technician t);

    void updateTechnicianToManager(Technician t);
    void updateTechnicianToSalesman(Technician t);

    void deleteTechnicianById(int id);
}
