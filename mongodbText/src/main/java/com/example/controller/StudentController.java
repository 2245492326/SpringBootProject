package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.controller.test.Code;
import com.alibaba.fastjson.JSON;
import com.example.controller.test.Result;
import com.example.entity.Bicycle;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    public StudentService studentService;

    //添加学生信息
    @PostMapping("/add")
    public Result addStudent(@RequestBody Student student) {
        boolean flag = studentService.addStudent(student);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg =flag? "添加成功" : "添加失败";
        return new Result(code, null, msg);
    }

    //修改学生信息
    @PostMapping("/update")
    public Result updateStudent(@RequestBody Student student) {
        boolean flag = studentService.updateStudent(student);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg = flag? "修改成功" : "修改失败";
        return new Result(code, null, msg);
    }

    //删除学生信息
    @PostMapping("/delete")
    public Result deleteStudent(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Integer id = jsonObject.getInteger("id");
        boolean flag = studentService.deleteStudent(id);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg = flag ? "删除成功" : "删除失败";
        return new Result(code,null,msg);
    }

        //分页查询学生信息
    @GetMapping("/getList")
    public Result getStudentList(@RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Integer pageSize = jsonObject.getInteger("pageSize");
        Integer pageNum = jsonObject.getInteger("pageNum");
        List<Student> students =studentService.getStudentList(pageSize,pageNum);
        Integer code = students != null ? Code.GET_OK : Code.GET_ERR;
        String msg = students != null ? "查询成功" : "查询失败";
        return new Result(code, students, msg);
    }

    //根据id查询学生信息
    @GetMapping("/getById")
    public Result getStudentById(@RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Integer id = jsonObject.getInteger("id");
        Student studentById = studentService.getStudentById(id);
        Integer code = studentById != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentById != null ? "查询成功" : "查询失败";
        return new Result(code, studentById,msg);
    }
}
