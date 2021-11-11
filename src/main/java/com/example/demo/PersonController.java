package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@EnableMongoRepositories
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello" + name + "!";
    }

    @PostMapping(value = "/Enterdetails")
    ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest personRequest) {


        PersonResponse personResponse =personService.createPerson( personRequest);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/Getdetails")
    ResponseEntity<PersonEntity> getPerson(@RequestParam(value = "name") String name) {


        PersonEntity p = personRepository.findByName(name);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PatchMapping(value = "/Editdetails")
    ResponseEntity<PersonResponse> editPerson(@Valid @RequestBody PersonPatchRequest personPatchRequest) {

        PersonResponse personResponse =personService.editDetails( personPatchRequest);

        // personRepository.save(person.get());
        // personRepository.delete(person.get());
        return new ResponseEntity<>(personResponse, HttpStatus.OK);


    }

    @PutMapping(value = "/Updatedetails")
    ResponseEntity<PersonResponse> UpdatePerson(@Valid @RequestBody PersonPutRequest personPutRequest) {
        PersonResponse personResponse =personService.updateDetails( personPutRequest);


        /*personRepository.save(person.get());*/
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/Deletedetails")
    ResponseEntity Deletedetails(@RequestParam(value = "id") ObjectId id) {
        personService.deleteDetails(id);

        return  ResponseEntity.noContent().build();

    }

}





