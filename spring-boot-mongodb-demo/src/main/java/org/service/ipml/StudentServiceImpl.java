package org.service.ipml;

import org.dao.StudentDao;
import org.entity.Bicycle;
import org.entity.Student;
import org.service.StudentService;
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

    @Override
    public Student getStudentById(int id) {
        return studentDao.studentById(id);
    }

    @Override
    public Bicycle getStudentByBicycleId(int bicycleId) {
        return studentDao.studentByBicycle(bicycleId);
    }
}
