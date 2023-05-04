package com.localhost;

import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBatisPlusMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextSelectAll() {
        //通过条件构造器查询一个list结合, 若没有条件, 则可以设置null为参数
        //SELECT id,name,age,email FROM user
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void contextInsertClass(){
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User( "张三", 24, "66@pp.com");
        userMapper.insert(user);
        System.out.println(user.getId());
    }

    @Test
    void contextDeleteMap(){
        //根据map集合中设置的条件删除
        //DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> hashMap = new HashMap<>();
        //key是表的列名(与实体类无关), value是值
        hashMap.put("user_name","张三");
        hashMap.put("age",24);
        userMapper.deleteByMap(hashMap);
    }

    @Test
    void contextDeleteBatchIds(){
        //通过id的集合来批量删除
        //DELETE FROM user WHERE id IN ( ? , ? )
        List<Integer> ids = Arrays.asList(1, 2);
        userMapper.deleteBatchIds(ids);
    }

}
