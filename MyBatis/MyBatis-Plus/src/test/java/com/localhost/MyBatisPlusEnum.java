package com.localhost;

import com.localhost.enums.SexEnum;
import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusEnum {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum(){
        User user = new User("333",33,null);
        //赋值的是MALE, 插入数据库会自动变为插入sex的值(1)
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);

        //SQL搜索出来的是1, 封装User会自动变成MALE
        User selectById = userMapper.selectById(user.getId());
        System.out.println(selectById);
    }

}
