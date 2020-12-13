package com.zq.staffmanageproject.service;

import com.zq.staffmanageproject.entity.Technician;
import com.zq.staffmanageproject.mapper.TechnicianMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {
    @Autowired
    TechnicianMapper technicianMapper;

    public Technician getTechnicianById(int id) {
        return technicianMapper.getTechnicianById(id);
    }

    public List<Technician> getTechnicianByName(String name) {
        return technicianMapper.getTechnicianByName(name);
    }

    public List<Technician> getALl() {
        return technicianMapper.getAll();
    }

    public Technician insertTechnician(Technician t) {
        technicianMapper.insertTechnicianToStaff(t);
        technicianMapper.insertTechnicianToTechnician(t);
        return t;
    }

    public void updateTechnician(Technician t) {
        switch(t.getLevel()) {
            case Technician -> {
                technicianMapper.updateTechnician(t);
            }
            case Manager -> {
                technicianMapper.updateTechnicianToManager(t);
            }
            case Salesman -> {
                technicianMapper.updateTechnicianToSalesman(t);
            }
        }
    }

    public void deleteTechnicianById(int id) {
        technicianMapper.deleteTechnicianById(id);
    }
}
