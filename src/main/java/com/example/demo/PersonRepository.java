
package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonEntity, ObjectId>{
    //@Query("{name:'?0'}")
    PersonEntity findByName (String name);
//@Query("{Age:'?0'}")
    /*Person findByAge (int Age);
//@Query("{email:'?0'}")
    Person findByEmail(String email);
*/
}

