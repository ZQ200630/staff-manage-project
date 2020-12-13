package com.zq.staffmanageproject.service;

import com.zq.staffmanageproject.entity.Manager;
import com.zq.staffmanageproject.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    public Manager getManagerById(int id){
        return managerMapper.getManagerById(id);
    }

    public List<Manager> getManagerByName(String name) {
        return managerMapper.getManagerByName(name);
    }

    public List<Manager> getAll() {
        return managerMapper.getAll();
    }

    public Manager insertManager(Manager m) {
        managerMapper.insertManagerToStaff(m);
        managerMapper.insertManagerToManager(m);
        return m;
    }

    public void updateManager(Manager m) {
        switch (m.getLevel()) {
            case Manager -> {
                managerMapper.updateManager(m);
            }
            case Salesman -> {
                managerMapper.updateManagerToSalesman(m);
            }
            case Technician -> {
                managerMapper.updateManagerToTechnician(m);
            }
        }
    }

    public void deleteManagerById(int id) {
        managerMapper.deleteManagerById(id);
    }
}
