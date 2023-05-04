package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.controller.tool.Result;
import com.example.controller.tool.status;
import com.example.pojo.Mygoods;
import com.example.pojo.User;
import com.example.service.IMygoodsService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cgs
 * @since 2023-04-02
 */
@Controller
public class MygoodsController {
    @Autowired
    private IMygoodsService mygoodsService;

    @Autowired
    private IUserService userService;

    @PostMapping("/user/addShoppingCart")
    @ResponseBody
    public Result addShoppingCart(@RequestBody String json){
        // 处理接收到的JSON字符串
        JSONObject jsonObject = JSON.parseObject(json);
        Integer goodsId = jsonObject.getInteger("goodsId");
        Integer goodsNum = jsonObject.getInteger("goodsNum");
        String username = jsonObject.getString("username");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User getUser = userService.getOne(wrapper, false);

        Mygoods mygoods = new Mygoods();
        mygoods.setUserId(getUser.getId());
        mygoods.setGoodsId(goodsId);
        mygoods.setGoodsNum(goodsNum);

        System.out.println(mygoods);

        boolean flag = mygoodsService.save(mygoods);
        Integer code = flag ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = flag ? "添加成功" : "添加失败";
        return new Result(code,null,msg);
    }

    @PostMapping("/getShoppingCartInfo")
    @ResponseBody
    public Result getShoppingCartInfo(@RequestBody String json){
        // 处理接收到的JSON字符串
        JSONObject jsonObject = JSON.parseObject(json);
        String username = jsonObject.getString("username");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User getUser = userService.getOne(wrapper, false);

        QueryWrapper<Mygoods> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("userid", getUser.getId());
        List<Mygoods> mygoodsList = mygoodsService.list(wrapper1);

        Integer code = mygoodsList != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = mygoodsList != null ? "获取成功" : "获取失败";
        return new Result(code,mygoodsList,msg);
    }

    @PostMapping("/user/removeGoodsShoppingCart")
    @ResponseBody
    public Result removeGoodsShoppingCart(@RequestBody Mygoods mygoods){
        boolean flag = mygoodsService.removeById(mygoods);
        Integer code = flag ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code,null,msg);
    }

    @PostMapping("/user/removeGoodssShoppingCart")
    @ResponseBody
    public Result removeGoodssShoppingCart(@RequestParam("mygoodsIds") List<Integer> mygoodsIds){
        boolean flag = mygoodsService.removeByIds(mygoodsIds);
        Integer code = flag ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code,null,msg);
    }


}
