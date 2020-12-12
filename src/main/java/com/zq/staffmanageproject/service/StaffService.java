package com.zq.staffmanageproject.service;

import com.zq.staffmanageproject.entity.StaffNumbers;
import com.zq.staffmanageproject.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffService {
    @Autowired
    StaffMapper staffMapper;

    public int countStaffNumber() {
        return staffMapper.countStaffNumber();
    }

    public StaffNumbers getStaffProportion() {
        List<Map<String, Object>> list = staffMapper.getStaffProportion();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(Map<String, Object> m : list) {
            map.put(m.get("level").toString(), ((Number) m.get("count")).intValue());
        }
        return new StaffNumbers(
                map.get("Manager") == null ? 0 : map.get("Manager"),
                map.get("Salesman") == null ? 0 : map.get("Salesman"),
                map.get("Technician") == null ? 0 : map.get("Technician")
                );
    }
}
