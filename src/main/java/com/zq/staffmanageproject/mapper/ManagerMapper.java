package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {
    Manager getManagerById(int id);
    Manager getManagerByName(String name);
    List<Manager> getAll();
    void insertManagerToStaff(Manager m);
    void insertManagerToManager(Manager m);
    void updateManager(Manager m);

    void updateManagerToTechnician(Manager m);
    void updateManagerToSalesman(Manager m);

    void deleteManagerById(int id);

}
