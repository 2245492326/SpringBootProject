package com.springboot.controller;


import com.springboot.Service.testExceptionService;
import com.springboot.controller.tool.Code;
import com.springboot.controller.tool.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Exception")
public class testExceptionController {
    @Autowired
    testExceptionService exceptionService;

    @GetMapping("/{id}")
    public Result idByBook(@PathVariable Integer id) {
        boolean flag = exceptionService.exception(id);
        System.out.println("触发");
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag);
    }
}
