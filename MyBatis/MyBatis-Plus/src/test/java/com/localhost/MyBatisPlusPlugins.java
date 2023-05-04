package com.localhost;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPlugins {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectPage(){
        Page<User>page = new Page<>(2,4);
        userMapper.selectPage(page,null);
        System.out.println("当前页数据: "+page.getRecords());
        System.out.println("当前页 页码："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
    @Test
    void testSelectPageTest() {
        Page<User> page = new Page<>(1, 4);
        userMapper.selectPageTest(page, 5);
        System.out.println("当前页数据: "+page.getRecords());
    }
    @Test
    void testSelectPage666() {
        System.out.println("你好");
    }
}
