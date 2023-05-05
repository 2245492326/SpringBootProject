package com.example.service.ipml;

import com.example.dao.BicycleDao;
import com.example.dao.StudentDao;
import com.example.entity.Bicycle;
import com.example.entity.Student;
import com.example.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleServiceImpl implements BicycleService {

    @Autowired
    public BicycleDao bicycleDao;


    @Override
    public boolean addBicycle(Bicycle bicycle) {
        try {
            bicycleDao.bicycleSave(bicycle);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateBicycle(Bicycle bicycle) {
        try {
            bicycleDao.bicycleUpdate(bicycle);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBicycle(int id) {
        try {
            bicycleDao.bicycleDelete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public List<Bicycle> getBicycleList(int pageSize, int pageNum) {
        return bicycleDao.pagingTest(pageSize, pageNum);
    }

    @Autowired
    public StudentDao studentDao;

    @Override
    public Bicycle getBicycleById(int id) {
        Bicycle bicycle = bicycleDao.bicycleById(id);
        Student student = studentDao.studentById(bicycle.getStudentId());
        bicycle.setStudent(student);
        return bicycle;
    }

}
