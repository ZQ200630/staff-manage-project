package com.zq.staffmanageproject.service;

import com.zq.staffmanageproject.entity.Level;
import com.zq.staffmanageproject.mapper.LevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    LevelMapper levelMapper;

    public Level getLevelById(int id) {
        return levelMapper.getLevelById(id);
    }

    public List<Level> getLevelByName(String name) {
        return levelMapper.getLevelByName(name);
    }
}
