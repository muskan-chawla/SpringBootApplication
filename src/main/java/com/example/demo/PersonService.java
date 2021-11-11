
package com.example.demo;

import com.example.demo.PersonPatchRequest;
import com.example.demo.PersonPutRequest;
import com.example.demo.PersonRequest;
import com.example.demo.PersonResponse;
import org.bson.types.ObjectId;

import javax.validation.Valid;


public interface PersonService
{
    PersonResponse createPerson(PersonRequest personRequest);
    PersonResponse updateDetails(@Valid PersonPutRequest personPutRequest);
    PersonResponse editDetails(@Valid PersonPatchRequest personPatchRequest);
    void deleteDetails(ObjectId id);
}


