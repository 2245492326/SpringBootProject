package com.localhost.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.localhost.enums.SexEnum;
import lombok.Data;

@Data
//当实体类名和表名不一样时, 设置对应表名(法1)
@TableName("t_user")
public class User {

    /*@TableId//当该主键不叫id时, 通过该属性指定为主键
    private Long uid;*/

    /*value属性用于指定主键的字段,解决属性名不对应的情况
    type属性用于指定主键生成策略, AUTO:为使用数据库的主键自增, 默认为ASSIGN_ID:雪花算法生成主键*/
    @TableId(value = "uid",type = IdType.AUTO)
    private Long id;

    //解决其他字段名不一致的情况
    @TableField("user_name")
    private String name;

    private Integer age;
    private String email;

    //通过枚举来设定1=男, 0=女
    private SexEnum sex;

    @Version //标识乐观锁版本号字段, 每次操作前都会核对版本号(版本号为条件)
    private Integer version;

    //逻辑删除-->将删除改完逻辑删除(将该值改为1); 对应的查询时也自动加上判断"该值=0"
    @TableLogic
    private Integer isDeleted;

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User() {
    }
}