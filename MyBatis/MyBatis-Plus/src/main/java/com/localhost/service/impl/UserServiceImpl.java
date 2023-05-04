package com.localhost.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.localhost.mapper.UserMapper;
import com.localhost.pojo.User;
import com.localhost.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
