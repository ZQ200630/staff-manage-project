package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.StaffNumbers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaffMapper {
    int countStaffNumber();
    List<Map<String, Object>> getStaffProportion();
}
