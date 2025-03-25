package com.bucnic.domains.basicOperations.array;

public class ArrayPrinter implements ArrayOperation {

    @Override
    public void Execute(int[] array) {
        for (var number : array){
            System.out.println(number);
        }
    }
}
