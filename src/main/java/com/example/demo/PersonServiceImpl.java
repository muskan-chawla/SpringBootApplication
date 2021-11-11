
package com.example.demo;

import com.example.demo.PersonEntity;
import com.example.demo.PersonRepository;
import com.example.demo.PersonRequest;
import com.example.demo.PersonResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonRepository personRepository;


    @Override
    public PersonResponse createPerson(PersonRequest personRequest) {

        PersonEntity p = new PersonEntity();
        p.setAge(personRequest.age);

        p.setName(personRequest.name);
        PersonEntity savedPerson = personRepository.save(p);
        PersonResponse personResponse = new PersonResponse();
        //to do populate feilds
        personResponse.setName(savedPerson.getName());
        personResponse.setAge(savedPerson.getAge());
        personResponse.setId(savedPerson.getId());
        return personResponse;

    }

    /*@Override
    public PersonResponse createPerson(PersonRequest personRequest) {
        return null;
    }*/

    public PersonResponse updateDetails(PersonPutRequest personPutRequest) {
        PersonEntity p = new PersonEntity();
        PersonResponse personResponse = new PersonResponse();

        Optional<PersonEntity> person = personRepository.findById(personPutRequest.getId());
        if (person.isPresent()) {
            PersonEntity personFromdb = person.get();
            personFromdb.setName(personPutRequest.name);
            personFromdb.setAge(personPutRequest.age);
            PersonEntity savedPerson = personRepository.save(personFromdb);
            personResponse.setName(savedPerson.getName());
            personResponse.setAge(savedPerson.getAge());
            personResponse.setId(savedPerson.getId());

        }
        return personResponse;
    }

    public PersonResponse editDetails(PersonPatchRequest personPatchRequest) {
        PersonEntity p = new PersonEntity();
        PersonResponse personResponse = new PersonResponse();

        Optional<PersonEntity> person = personRepository.findById(personPatchRequest.getId());

        if (person.isPresent()) {
            if (personPatchRequest.getAge() > 0) {
                person.get().setAge(personPatchRequest.getAge());
            }
            if (personPatchRequest.getName() != null) {
                person.get().setName(personPatchRequest.getName());
            }
            PersonEntity savedPerson = personRepository.save(person.get());

            personResponse.setName(savedPerson.getName());
            personResponse.setAge(savedPerson.getAge());
            personResponse.setId(savedPerson.getId());

        }
        return personResponse;

    }


    public void deleteDetails(ObjectId id) {
        Optional<PersonEntity> person = personRepository.findById(id);

        personRepository.delete(person.get());

    }

}


