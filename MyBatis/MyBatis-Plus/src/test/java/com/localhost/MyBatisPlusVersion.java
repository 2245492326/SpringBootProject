package com.localhost;

import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusVersion {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testVersion() {
        //小李查询乐观锁年龄
        User userLi = userMapper.selectById(1);
        //小王查询乐观锁年龄
        User userWang = userMapper.selectById(1);

        //小李将乐观锁年龄+50
        userLi.setAge(userLi.getAge() + 50);
        //UPDATE t_user SET user_name=?, age=?, version=? WHERE uid=? AND version=? AND is_deleted=0
        userMapper.updateById(userLi);
        //小王将乐观锁年龄-30
        userWang.setAge(userWang.getAge() - 30);
        int result = userMapper.updateById(userWang);

        if (result == 0) {
            //操作失败，重试
            User userNew = userMapper.selectById(1);
            userNew.setAge(userNew.getAge() - 30);
            userMapper.updateById(userNew);
        }

        //老板查询乐观锁年龄
        User userLao= userMapper.selectById(1);
        System.out.println("老板查询的乐观锁年龄：" + userLao.getAge());
    }
}
