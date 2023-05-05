package org.dao;

import org.entity.Bicycle;
import org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BicycleDao {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public BicycleDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    //文档操作 添加
    public void bicycleSave(Bicycle bicycle) {
        mongoTemplate.save(bicycle);//save 方法在_id 存在时更新数据
        //mongoTemplate.findAll(Bicycle.class).forEach(System.out::println);
    }

    //文档操作 更新
    public void bicycleUpdate(Bicycle bicycle) {
        //1.更新符合条件的第一条数据
        Update update = new Update();
        //更新字段
        update.set("_id", bicycle.getId());
        update.set("name", bicycle.getName());
        update.set("student_id", bicycle.getStudentId());
        //更新符合条件第一条数据
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(bicycle.getId())), update, Bicycle.class);
    }

    //文档操作 删除
    public void bicycleDelete(int id) {
        //1.删除符合条件的第一条数据
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), Bicycle.class);
    }

    //文档操作 分页查询
    public List<User> pagingTest(int pageSize,int pageNum) {
        Query query = new Query();
        //排序
        query.with(Sort.by(Sort.Order.asc("id")));
        //跳过多少条
        query.skip((pageNum - 1) * pageSize);
        //显示多少条
        query.limit(pageSize);
        //查询
        return mongoTemplate.find(query, User.class);
    }

    //文档操作 查询所属学生
    public Bicycle bicycleByStudent(int studentId){
        Query query = new Query();
        query.addCriteria(Criteria.where("student_id").is(studentId));
        return mongoTemplate.findOne(query, Bicycle.class);
    }

    //文档操作 查询id查询自行车
    public Bicycle bicycleById(int id){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Bicycle.class);
    }

}
