package com.bucnic.domains.basicOperations.people;

import com.bucnic.domains.basicOperations.interfaces.InputHandler;
import com.bucnic.domains.basicOperations.interfaces.OutputHandler;
import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class PeopleService {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final List<Person> people = new ArrayList<>();

    public PeopleService(InputHandler inputHandler, OutputHandler outputHandler){
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void addPerson(){
        this.outputHandler.writeLine("Insert a person name and age (separated by space)");
        var input = this.inputHandler.readStrings();
        var person = convertPersonFromString(input);
        if (person != null) {
            people.add(person);
        }
        else{
            this.outputHandler.writeLine("Wrong person details inserted, please retry");
        }
    }

    public void printPeople(PeopleServiceRequest request){
        var peopleFiltered = getPeople(request);
        PrintPeople(peopleFiltered);
    }



    private Person convertPersonFromString(String input){
        Person person = null;

        var values = input.split(" ");
        if (values.length == 2){
            person = new Person();
            person.setName(values[0]);
            try{
                person.setAge(Integer.parseInt(values[1]));
            } catch (NumberFormatException e) {
                person.setAge(0);
            }
        }

        return person;
    }

    private void PrintPeople(List<Person> people){
        for (var person : people){
            this.outputHandler.writeLine(person.toString());
        }
    }

    @VisibleForTesting
    public void addPerson(Person person){
        this.people.add(person);
    }

    @VisibleForTesting
    public List<Person> getPeople(PeopleServiceRequest request){
        List<Person> response;

        if (request.isAdultOnly()){
            response =  this.people.stream()
                    .filter(Person::IsAdult).toList();
        }
        else{
            response = this.people;
        }

        return response;
    }


}
