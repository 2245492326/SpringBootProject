package org.dao;

import org.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentDaoTest {


    @Test
    void studentSave() {
        Student student = new Student(10, "aaaa", 2);
        new StudentDao().studentSave(student);
    }
}