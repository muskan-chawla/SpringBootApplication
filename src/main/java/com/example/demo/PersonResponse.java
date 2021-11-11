package com.example.demo;

import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@Slf4j

public class PersonResponse {
    int age;
    String Name;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    ObjectId id;





    public void setAge(int age) {
        this.age = age;
    }


    public void setName(String Name) {
        this.Name = Name;
    }




    public int getAge() {
        return age;
    }
    public String getName() {
        return Name;
    }



}
