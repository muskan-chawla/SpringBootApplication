
package com.example.demo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class PersonPutRequest {
    @NotNull
    public String name;
    @Min(1)
    public int age;

    ObjectId id;

    public PersonPutRequest() {

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

