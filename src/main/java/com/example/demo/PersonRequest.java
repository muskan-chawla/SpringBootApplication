
package com.example.demo;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
//@Slf4j
@Data

public class PersonRequest {

    @NotNull
    public String name;
    @Min(1)
    public int age;
    ObjectId Id;





    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}

