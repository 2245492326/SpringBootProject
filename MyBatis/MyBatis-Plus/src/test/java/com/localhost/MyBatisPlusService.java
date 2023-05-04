package com.localhost;

import com.localhost.pojo.User;
import com.localhost.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusService {
    @Autowired
    private UserService userService;

    @Test
    void  contextGetCount(){
        //查询总记录数
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    void contextInsertList(){
        //批量添加
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <=5; i++) {
            User user = new User( "name:" + i, 20 + i, "email:" + i);
            userList.add(user);
        }
        boolean saveBatch = userService.saveBatch(userList);
        System.out.println(saveBatch);
    }
}
