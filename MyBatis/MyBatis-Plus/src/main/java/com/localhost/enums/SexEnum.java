package com.localhost.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    //男性
    MALE(1,"男"),
    //女性
    FEMALE(2,"女");

    @EnumValue  //将注解所标识的属性的值存储到数据库中
    private final Integer sex;
    private final String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
