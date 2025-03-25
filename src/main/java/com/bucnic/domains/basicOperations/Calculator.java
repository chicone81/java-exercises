package com.bucnic.domains.basicOperations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {

    private int a;
    private int b;

    public int Sum(){
        return a + b;
    }
}
