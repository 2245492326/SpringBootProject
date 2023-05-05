package org.service;

import org.entity.Bicycle;
import org.entity.Student;
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

    /**
     * 根据id查询所有单车
     * @param bicycleId
     * @return
     */
    public Bicycle getStudentByBicycleId(int bicycleId);

}
