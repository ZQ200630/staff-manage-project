package com.zq.staffmanageproject.mapper;

import com.zq.staffmanageproject.entity.Level;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelMapper {
    Level getLevelById(int id);
    List<Level> getLevelByName(String name);
}
