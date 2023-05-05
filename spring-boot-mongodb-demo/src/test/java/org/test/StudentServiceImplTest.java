package org.test;


import org.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.StudentService;
import org.service.ipml.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest{

    @Test
    public void addStudent() {

        StudentServiceImpl studentService = new StudentServiceImpl();
        Student student = new Student(10, "aaaa", 2);
        studentService.addStudent(student);
    }

}