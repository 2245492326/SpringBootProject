package com.cgs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cgs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-11-23 15:08:15
* @Entity com.cgs.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    //选择性添加, 为null不出现在SQL中
    int insertSelective(@Param("user") User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    //操作后跟的是操作的字段, by后的是条件
    int updateAgeAndUserNameByUid(@Param("age") Integer age, @Param("userName") String userName, @Param("uid") Long uid);
    //搜索年龄和用户名字段, 条件是年龄区间
    List<User> selectAgeAndUserNameByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();

    List<User> selectAgeAndSexBySex(@Param("sex") Integer sex);


}




