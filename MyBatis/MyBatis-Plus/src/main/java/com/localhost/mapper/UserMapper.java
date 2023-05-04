package com.localhost.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.localhost.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

//解决IDEA没找到对应的Bean的问题
@Repository
//BaseMapper是mybatis-plus提供的通用的Mapper其中提供了对单表的各种增删改查的方法
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过年龄查询用户并分页
     * @param page MyBatisPlus所提供的分页对象, 必须位于第一个参数位, 与SQL无关
    */
    Page<User> selectPageTest(@Param("page") Page<User> page, @Param("age") Integer age);
}

