package com.zq.staffmanageproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.zq.staffmanageproject.mapper")
public class StaffManageProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffManageProjectApplication.class, args);
    }

}
