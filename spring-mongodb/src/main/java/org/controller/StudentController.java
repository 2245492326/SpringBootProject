package org.controller;

import org.controller.test.Code;
import org.controller.test.Result;
import org.entity.Bicycle;
import org.entity.Student;
import org.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
public class StudentController {

    @Autowired
    public StudentService studentService;

    //添加学生信息
    @PostMapping("/add")
    @ResponseBody
    public Result addStudent(@RequestBody Student student) {
        boolean flag = studentService.addStudent(student);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg =flag? "添加成功" : "添加失败";
        return new Result(code, null, msg);
    }

    @PostMapping("/update")
    public Result updateStudent(@RequestBody Student student) {
        boolean flag = studentService.updateStudent(student);
        Integer code = flag ? Code.POST_OK : Code.POST_ERR;
        String msg = flag? "修改成功" : "修改失败";
        return new Result(code, null, msg);
    }

    @GetMapping("/getList")
    public Result getStudentList(int pageSize,int pageNum){
        List<Student> students =studentService.getStudentList(pageSize,pageNum);
        Integer code = students != null ? Code.GET_OK : Code.GET_ERR;
        String msg = students != null ? "查询成功" : "查询失败";
        return new Result(code, students, msg);
    }

    @GetMapping("/getById")
    @ResponseBody
    public Result getStudentById(int id){
        Student student = studentService.getStudentById(id);
        Integer code = student != null ? Code.GET_OK : Code.GET_ERR;
        String msg = student != null ? "查询成功" : "查询失败";
        return new Result(code, student,msg);
    }

    @GetMapping("/getByBicycleId")
    public Result getStudentByBicycleId(int bicycleId){
        Bicycle bicycle = studentService.getStudentByBicycleId(bicycleId);
        Integer code =bicycle != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bicycle != null ? "查询成功" : "查询失败";
        return new Result(code, bicycle,msg);
    }
}
