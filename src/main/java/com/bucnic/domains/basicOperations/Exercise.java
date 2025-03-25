package com.bucnic.domains.basicOperations;

import lombok.Getter;

@Getter

public enum Exercise {
    Calculator(1,"Calculator"),
    StringConcatenate(2,"String Concatenate"),
    Array(3,"Array operations"),
    Map(4,"Map occurrences"),
    Random(5,"Get random numbers")
    ;

    private final int value;
    private final String description;

    Exercise(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Exercise fromValue(int value){
        for (Exercise exercise : values()){
            if (exercise.getValue() == value){
                return exercise;
            }
        }
        return null;
    }
}
