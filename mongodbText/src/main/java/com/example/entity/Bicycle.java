package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Bicycles") //这个类实例就代表 mongo 中一条文档
public class Bicycle {
    @Id
    private Integer id;
    private String name;

    private Integer studentId;

    private Student student;

    public Bicycle() {
    }

    public Bicycle(Integer id, String name, Integer studentId) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    public int getId() {
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

}
