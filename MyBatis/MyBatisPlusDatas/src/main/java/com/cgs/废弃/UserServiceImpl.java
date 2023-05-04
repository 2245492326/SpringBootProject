package com.cgs.废弃;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
@DS("master")//指定数据源, 也可以加在方法上, 实现同一个实体类, 操作不同的数据库
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
