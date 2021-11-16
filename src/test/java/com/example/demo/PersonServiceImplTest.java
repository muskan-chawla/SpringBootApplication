package com.example.demo;

import org.assertj.core.api.Assertions;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    void testPersonCreate() {
        PersonEntity P = new PersonEntity();
        P.setAge(22);
        P.setName("muskan");

        when(personRepository.save(any(PersonEntity.class)
        )).thenReturn(P);

    PersonRequest pq = new PersonRequest();
        pq.setAge(22);
        pq.setName("muskan");
        PersonResponse personResponse = personService.createPerson(pq);
        Assertions.assertThat(personResponse.getAge()).isEqualTo(P.getAge());

    }
    @Test
    void testUpdateDetails() {
        PersonPutRequest ppq = new PersonPutRequest();
        ppq.setAge(22);
        ppq.setName("Muskan");
        ppq.setId(new ObjectId("6189473307c0e80144d13066"));
        PersonEntity p = new PersonEntity();
        //PersonPutRequest ppq = new PersonPutRequest();
        p.setAge(22);
        p.setName("Muskan");


       when(personRepository.findById(ppq.getId()
        )).thenReturn(Optional.of(p));

        Mockito.when(personRepository.save(any(PersonEntity.class))).thenReturn(p);

        PersonResponse personResponse = personService.updateDetails(ppq);
        Assertions.assertThat(personResponse.getAge()).isEqualTo(p.getAge());
    }
    @Test
    void testEditDetails()
    {
        PersonPatchRequest patchRequest=new PersonPatchRequest();

        patchRequest.setAge(22);
        patchRequest.setName("Muskan");
        patchRequest.setId(new ObjectId("6189479b07c0e80144d13067"));
        PersonEntity Pe=new PersonEntity();
        Pe.setName("Muskan");
        Pe.setAge(22);

        when(personRepository.findById(patchRequest.getId())).thenReturn(Optional.of(Pe));
        when(personRepository.save(any(PersonEntity.class))).thenReturn(Pe);

        PersonResponse personResponse=personService.editDetails(patchRequest);
        Assertions.assertThat(personResponse.getAge()).isEqualTo(Pe.getAge());

    }
    @Test
    void testDeleteDetails()
    {
        PersonEntity personEntity=new PersonEntity();
        personEntity.setName("Muskan");
        personEntity.setAge(22);
        ObjectId id=new ObjectId("6189479b07c0e80144d13067");
        when(personRepository.findById(id)).thenReturn(Optional.of(personEntity));
         doNothing().when(personRepository).delete(personEntity);
         personService.deleteDetails(id);
        // verify(personRepository.delete(personEntity));

    }
}




