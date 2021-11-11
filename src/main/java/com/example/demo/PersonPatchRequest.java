package com.example.demo;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class PersonPatchRequest {
    int age;
    String name;
    ObjectId id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

