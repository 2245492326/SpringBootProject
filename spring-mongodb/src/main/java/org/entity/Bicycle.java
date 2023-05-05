package org.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Bicycles") //这个类实例就代表 mongo 中一条文档
public class Bicycle {
    @Id
    private int id;
    private String name;

    @Field("student_id")
    private int studentId;

    public Bicycle() {
    }

    public Bicycle(int id, String name, int studentId) {
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
