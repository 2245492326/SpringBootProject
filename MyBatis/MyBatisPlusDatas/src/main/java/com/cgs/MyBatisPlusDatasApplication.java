package com.cgs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cgs.mapper")
public class MyBatisPlusDatasApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusDatasApplication.class, args);
    }
}
