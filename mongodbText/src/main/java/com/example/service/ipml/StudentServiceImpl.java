package com.example.service.ipml;


import com.example.dao.BicycleDao;
import com.example.dao.StudentDao;
import com.example.entity.Bicycle;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentDao studentDao;


    @Override
    public boolean addStudent(Student student) {
        try {
            studentDao.studentSave(student);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            studentDao.studentUpdate(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try {
            studentDao.studentDelete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public List<Student> getStudentList(int pageSize, int pageNum) {
        return studentDao.pagingTest(pageSize, pageNum);
    }

    @Autowired
    private BicycleDao bicycleDao;

    @Override
    public Student getStudentById(int id) {
        Student student = studentDao.studentById(id);
        Bicycle bicycle = bicycleDao.bicycleById(student.getCarId());
        student.setBicycle(bicycle);
        return student;
    }

}
