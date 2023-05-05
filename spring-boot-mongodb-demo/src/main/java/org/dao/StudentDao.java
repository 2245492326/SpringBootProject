package org.dao;

import org.entity.Bicycle;
import org.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    //文档操作 添加
    public void studentSave(Student student) {
        mongoTemplate.save(student);//save 方法在_id 存在时更新数据
        //mongoTemplate.findAll(Student.class).forEach(System.out::println);
    }

    //文档操作 更新
    public void studentUpdate(Student student) {
        //1.更新符合条件的第一条数据
        Update update = new Update();
        //更新字段
        update.set("_id", student.getId());
        update.set("name", student.getName());
        update.set("car_id", student.getCarId());
        //更新符合条件第一条数据
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(student.getId())), update, Student.class);
    }

    //文档操作 删除
    public void studentDelete(int id) {
        //1.删除符合条件的第一条数据
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Student.class);
    }

    //文档操作 分页查询
    public List<Student> pagingTest(int pageSize,int pageNum) {
        Query query = new Query();
        //排序
        query.with(Sort.by(Sort.Order.asc("id")));
        //跳过多少条
        query.skip((pageNum - 1) * pageSize);
        //显示多少条
        query.limit(pageSize);
        //查询
        return mongoTemplate.find(query, Student.class);
    }

    //文档操作 查询所有车辆
    public Bicycle studentByBicycle(int carId){
        Query query = new Query();
        query.addCriteria(Criteria.where("car_id").is(carId));
        return mongoTemplate.findOne(query, Bicycle.class);
    }

    //文档操作 根据id查询学生
    public Student studentById(int id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Student.class);
    }

}
