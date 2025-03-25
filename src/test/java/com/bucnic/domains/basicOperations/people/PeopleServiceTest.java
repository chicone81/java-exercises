package com.bucnic.domains.basicOperations.people;

import com.bucnic.domains.basicOperations.interfaces.InputHandler;
import com.bucnic.domains.basicOperations.interfaces.OutputHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PeopleServiceTest {

    @Mock
    private InputHandler inputHandler;

    @Mock
    private OutputHandler outputHandler;

    @InjectMocks
    private PeopleService peopleService;

//    public PeopleServiceTest(){
//        this.peopleService = new PeopleService(this.inputHandler, this.outputHandler);
//    }

    @Test
    void addPerson() {
        when(this.inputHandler.readStrings())
                .thenReturn("Nicola 44");

        this.peopleService.addPerson();
        var people = this.peopleService.getPeople(new PeopleServiceRequest());

        assertThat(people)
                .hasSize(1)
                .extracting(Person::getName, Person::getAge)
                .containsExactly(
                        tuple("Nicola", 44)
                );
    }

    @Test
    void printPeople() {
        this.peopleService.addPerson(new Person("Alice",16));
        this.peopleService.addPerson(new Person("Nicola",44));

        this.peopleService.printPeople(new PeopleServiceRequest());

        verify(outputHandler).writeLine("Person(name=Nicola, age=44)");
    }
}