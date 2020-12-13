package com.zq.staffmanageproject.controller;

import com.zq.staffmanageproject.entity.*;
import com.zq.staffmanageproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TestController {
    @Autowired
    ManagerService managerService;

    @Autowired
    SalesmanService salesmanService;

    @Autowired
    TechnicianService technicianService;

    @Autowired
    LevelService levelService;

    @Autowired
    StaffService staffService;

    @GetMapping("/")
    public String s() {
        return levelService.getLevelById(2).toString();
    }

    @GetMapping(value = "/GetStaffById/{id}")
    public Staff getStaffById(@PathVariable("id") Integer id) {
        switch (levelService.getLevelById(id)) {
            case Manager -> {
                return managerService.getManagerById(id);
            }
            case Salesman -> {
                return salesmanService.getSalesmanById(id);
            }
            case Technician -> {
                return technicianService.getTechnicianById(id);
            }
        }
        return null;
    }

    @GetMapping(value = "/GetStaffByName/{name}")
    public List<Staff> getStaffByName(@PathVariable("name") String name) {
        List<Staff> staffList = new ArrayList<Staff>();
        staffList.addAll(managerService.getManagerByName(name));
        staffList.addAll(salesmanService.getSalesmanByName(name));
        staffList.addAll(technicianService.getTechnicianByName(name));
        return staffList;
    }
    
    @GetMapping(value = "/GetStaffsByGroup/{groupName}")
    public List<Staff> getStaffsByGroup(@PathVariable("groupName") String name) {
        List<Staff> result = new ArrayList<Staff>();
        switch (Level.valueOf(name)) {
            case Manager -> {
                result.addAll(managerService.getAll());
            }
            case Salesman -> {
                result.addAll(salesmanService.getAll());
            }
            case Technician -> {
                result.addAll(technicianService.getALl());
            }
        }
        return result;
    }

    @GetMapping("/deleteStaffById/{id}")
    public void deleteStaffById(@PathVariable("id") int id) {
        switch (levelService.getLevelById(id)) {
            case Manager -> {
                managerService.deleteManagerById(id);
            }
            case Salesman -> {
                salesmanService.deleteSalesmanById(id);
            }
            case Technician -> {
                technicianService.deleteTechnicianById(id);
            }
        }
    }

    @PostMapping("/updateManager")
    public void updateStaff(@RequestBody Manager m) {
        managerService.updateManager(m);
    }

    @PostMapping("/updateSalesman")
    public void updateStaff(@RequestBody Salesman s) {
        salesmanService.updateSalesman(s);
    }

    @PostMapping("/updateTechnician")
    public void updateStaff(@RequestBody Technician t) {
        technicianService.updateTechnician(t);
    }

    @PostMapping("/insertManager")
    public void insertStaff(@RequestBody Manager m) {
        managerService.insertManager(m);
    }

    @PostMapping("/insertSalesman")
    public void insertStaff(@RequestBody Salesman s) {
        salesmanService.insertSalesman(s);
    }

    @PostMapping("/insertTechnician")
    public void insertStaff(@RequestBody Technician t) {
        technicianService.insertTechnician(t);
    }

    @GetMapping("/test")
    public void t() {
        for (int i = 0; i < 3000; i++) {
            managerService.insertManager(new Manager(String.valueOf(i), i, Level.Manager, "ZHAN"));
            salesmanService.insertSalesman(new Salesman(String.valueOf(i), i, Level.Salesman, i, "123123"));
            technicianService.insertTechnician(new Technician(String.valueOf(i), i, Level.Technician, i, "123123"));
        }
    }

    @GetMapping("getStaffNumber")
    public int getStaffNumber() {
        return staffService.countStaffNumber();
    }

    @GetMapping("getStaffProportion")
    public StaffNumbers getStaffProportion() {
        return staffService.getStaffProportion();
    }
}
