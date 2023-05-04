package com.localhost;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusWrapper {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectWrapper(){
        //查询: 名字中含有w, 年龄在20到30之间, email不为null的值
        /*SELECT ... FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        //%w%(String), 20(Integer), 30(Integer)*/
        //创建条件列表
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //添加条件
        wrapper.like("user_name","w")
                      .between("age",20,30)
                      .isNotNull("email");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testSelectWrapperOrderBy(){
        //查询: 按照年龄的降序排序, 若年龄相同, 则按照id升序排列
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age").orderByAsc("uid");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testSelectWrapperMaps(){
        //查询用户的用户名,年龄,邮箱信息
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        QueryWrapper<User>wrapper = new QueryWrapper<>();
        wrapper.select("user_name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void testSelectWrapperUbSql(){
        //通过子查询, 查id小于等于100的用户信息
        QueryWrapper<User>wrapper = new QueryWrapper<>();
        wrapper.inSql("uid","select uid from t_user where uid<=100");
        List<User>list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void testDeleteWrapper(){
        //删除邮箱地址为null的用户信息
        QueryWrapper<User>wrapper  = new QueryWrapper<>();
        wrapper.isNull("email");
        userMapper.delete(wrapper);
    }

    @Test
    void testUpdate_QueryWrapper(){
        //修改年龄大于20且名字中有w的, 或email为null的
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User>wrapper= new QueryWrapper<>();
        wrapper.gt("age",20).like("user_name","w")
                .or().isNull("email");
        User user = new User();//user有数据的字段才会被修改
        user.setName("小明");
        user.setEmail("小明@pp.com");
        userMapper.update(user,wrapper);
    }

    @Test
    void testUpdate_QueryWrapperLambda(){
        //修改名字包含w且(年龄大于20或邮箱为null)的用户
        //Lambda中的条件优先执行(Wrapper条件)[Consumer]
        QueryWrapper<User>wrapper= new QueryWrapper<>();
        wrapper.like("user_name","w")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("小红");
        user.setEmail("小红@qq.com");
        userMapper.update(user,wrapper);
    }

    @Test
    void testUpdate_UpdateWrapper(){
        //修改名字包含w且(年龄大于20或邮箱为null)的用户
        //通过UpdateWrapper填写修改的字段
        UpdateWrapper<User>wrapper = new UpdateWrapper<>();
        wrapper.like("user_name","w")
                .and(i->i.gt("age",20).or().isNull("email"));
        wrapper.set("user_name","小黑").set("email","小黑@pp.com");
        userMapper.update(null,wrapper);
    }

    @Test
    void testUpdateCondition(){
        //动态语句: 利用语句中的Condition判断条件来实现动态语句
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String username="a";
        Integer ageBegin=null;
        Integer ageEnd=30;

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void testUpdate_LambdaQueryWrapper_Lambda(){
        //防止表列名写错, 可以通过LambdaQueryWrapper然后User::getAge的形式代表列名
        LambdaQueryWrapper<User>wrapper=new LambdaQueryWrapper<>();
        wrapper.like(User::getName,"w")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        User user = new User();
        user.setName("小红");
        user.setEmail("小红@qq.com");
        userMapper.update(user,wrapper);
    }
}
