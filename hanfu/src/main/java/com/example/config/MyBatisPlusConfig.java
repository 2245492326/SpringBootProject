package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//扫描mapper接口所在的包
@MapperScan("com.example.mapper")
public class MyBatisPlusConfig {
}
