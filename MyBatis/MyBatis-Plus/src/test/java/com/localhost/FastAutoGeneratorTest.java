package com.localhost;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * Date:2022/2/15
 * Author:ybc
 * Description:
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        //会生成controller+pojo(如果有自增默认使用数据库自增, 会为主键起别名)+mapper+service+Mapper.xml
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/ssm?characterEncoding=utf-8&userSSL=false", "root", "123456")
            //全局配置
            .globalConfig(builder -> {builder
                        .author("cgs") // 设置作者
                        //.enableSwagger() // 开启 swagger 模式
                        .fileOverride() // 覆盖已生成文件
                        .outputDir("S:\\aYingWen\\BianCheng\\JAVA\\MyBatisPlus"); // 指定输出目录
            })
            //设置包结构
            .packageConfig(builder -> {builder
                    //文件会生成在com.localhost下
                    .parent("com") // 设置父包名
                    .moduleName("localhost") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.xml, "S:\\aYingWen\\BianCheng\\JAVA\\MyBatisPlus")); // 设置mapperXml的生成路径
            })
            //策略配置
            .strategyConfig(builder -> {builder
                    .addInclude("t_user") // 设置需要生成的表名
                    .addTablePrefix("t_", "c_"); // 设置过滤表前缀(映射表名时自动去掉的前缀)
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();



    }
}
