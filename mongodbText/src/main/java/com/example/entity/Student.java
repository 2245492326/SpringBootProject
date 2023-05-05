package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Students") //这个类实例就代表 mongo 中一条文档
public class Student {

    @Id //用来将这个类 id 映射文档中_id
    private Integer id;

    private String name;

    private Integer carId;

    private Bicycle bicycle;

    public Student() {
    }

    public Student(Integer id, String name, Integer carId) {
        this.id = id;
        this.name = name;
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carId='" + carId + '\'' +
                '}';
    }
    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
