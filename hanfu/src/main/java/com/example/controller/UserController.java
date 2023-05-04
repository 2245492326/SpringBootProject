package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.controller.tool.Result;
import com.example.controller.tool.status;
import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cgs
 * @since 2023-04-01
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/user/Login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername()).eq("password", user.getPassword());
        User getUser = userService.getOne(wrapper, false);
        Integer code = getUser != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = getUser != null ? "欢迎用户 " + getUser.getUsername() + " 的使用！" : "登录失败, 请重试";
        assert getUser != null;
        return new Result(code, getUser.getUsername(), msg);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/user/Register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User getUser = userService.getOne(wrapper, false);
        if (getUser != null) {
            return new Result(status.OPERATION_FAILURE, null,"用户名已存在");
        }else {
            userService.save(user);
            return new Result(status.OPERATION_SUCCESS, null,"注册成功");
        }
    }

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    @PostMapping ("/getUser")
    @ResponseBody
    public Result getUser(@RequestBody User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User getUser = userService.getOne(wrapper, false);
        Integer code = getUser != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = getUser != null ? "获取成功" : "获取失败";
        assert getUser != null;
        return new Result(code, getUser, msg);
    }

    @GetMapping ("/getUsers")
    @ResponseBody
    public Result getUsers() {
        List<User> list = userMapper.selectList(null);
        Integer code = list != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = list != null ? "获取成功" : "获取失败";
        return new Result(code,list,msg);
    }


}
