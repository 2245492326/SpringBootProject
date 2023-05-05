package com.example.service;


import com.example.entity.Bicycle;
import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public boolean addStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     */
    public boolean updateStudent(Student student);


    /**
     * 根据id删除
     * @param id
     */
    public boolean deleteStudent(int id);

    /**
     * 分页查询
     * @param pageSize
     * @param pageNum
     * @return
     */
    public List<Student> getStudentList(int pageSize,int pageNum);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Student getStudentById(int id);

}
