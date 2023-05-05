package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.controller.test.Code;
import com.example.controller.test.Result;
import com.example.entity.Bicycle;
import com.example.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bicycle")
@RestController
@CrossOrigin
public class BicycleController {

    @Autowired
    public BicycleService bicycleService;

    //添加车辆信息
    @PostMapping("/add")
    public Result addBicycle(@RequestBody Bicycle bicycle) {
        boolean flag = bicycleService.addBicycle(bicycle);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg =flag? "添加成功" : "添加失败";
        return new Result(code, null, msg);
    }

    //修改车辆信息
    @PostMapping("/update")
    public Result updateBicycle(@RequestBody Bicycle bicycle) {
        boolean flag = bicycleService.updateBicycle(bicycle);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg = flag? "修改成功" : "修改失败";
        return new Result(code, null, msg);
    }

    //删除车辆信息
    @PostMapping("/delete")
    public Result deleteBicycle(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Integer id = jsonObject.getInteger("id");
        boolean flag = bicycleService.deleteBicycle(id);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code,null,msg);
    }

        //分页查询车辆信息
    @GetMapping("/getList")
    public Result getBicycleList(@RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Integer pageSize = jsonObject.getInteger("pageSize");
        Integer pageNum = jsonObject.getInteger("pageNum");
        List<Bicycle> bicycles =bicycleService.getBicycleList(pageSize,pageNum);
        Integer code = bicycles != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bicycles != null ? "查询成功" : "查询失败";
        return new Result(code, bicycles, msg);
    }

    //根据id查询车辆信息
    @GetMapping("/getById")
    public Result getBicycleById(@RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Integer id = jsonObject.getInteger("id");
        Bicycle bicycleById = bicycleService.getBicycleById(id);
        Integer code = bicycleById != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bicycleById != null ? "查询成功" : "查询失败";
        return new Result(code, bicycleById,msg);
    }
}
