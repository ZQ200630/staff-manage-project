package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.Level;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelMapper {
    Level getLevelById(int id);
    Level getLevelByName(String name);
}
