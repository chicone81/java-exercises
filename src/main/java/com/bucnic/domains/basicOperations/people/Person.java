package com.bucnic.domains.basicOperations.people;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    public boolean IsAdult(){
        return this.age >= 18;
    }
}
