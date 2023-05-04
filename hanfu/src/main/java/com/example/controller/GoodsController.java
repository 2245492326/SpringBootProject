package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.controller.tool.Result;
import com.example.controller.tool.status;
import com.example.mapper.GoodsMapper;
import com.example.pojo.Goods;
import com.example.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cgs
 * @since 2023-04-01
 */
@Controller
public class GoodsController {
    @Autowired
    private IGoodsService goodsServices;
    @Autowired
    private GoodsMapper goodsMapper;

    @PostMapping("/user/addGoods")
    @ResponseBody
    public Result addGoods(@RequestBody Goods goods){
        boolean flag = goodsServices.save(goods);
        Integer code = flag ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = flag ? "添加成功" : "添加失败";
        return new Result(code,null,msg);
    }

    @GetMapping("/user/getPopularGoods")
    @ResponseBody
    public Result getPopularGoods(){
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("PurchaseQuantity").last("LIMIT 7");
        List<Goods> list = goodsMapper.selectList(wrapper);
        Integer code = list != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = list != null ? "获取成功" : "获取失败";
        return new Result(code,list,msg);
    }

    @GetMapping("/user/getAllgoodsInfo")
    @ResponseBody
    public Result getAllgoodsInfo(){
        List<Goods> list = goodsMapper.selectList(null);
        Integer code = list != null ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = list != null ? "获取成功" : "获取失败";
        return new Result(code,list,msg);
    }

    @PostMapping("/user/addNumberHits")
    @ResponseBody
    public Result addNumberHits(@RequestBody Goods goods){
        System.out.println(goods.getId());
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        Goods byIdGoods = goodsServices.getById(goods.getId());
        int purchaseQuantity= byIdGoods.getPurchaseQuantity();
        byIdGoods.setPurchaseQuantity(++purchaseQuantity);
        boolean flag = goodsServices.updateById(byIdGoods);
        Integer code = flag ? status.OPERATION_SUCCESS : status.OPERATION_FAILURE;
        String msg = flag ? "添加成功" : "添加失败";
        Map<String, Object> map = goodsServices.getMap(wrapper);
        return new Result(code,null,msg);

    }


}
