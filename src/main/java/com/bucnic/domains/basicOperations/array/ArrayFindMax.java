package com.bucnic.domains.basicOperations.array;

public class ArrayFindMax implements ArrayOperation {
    @Override
    public void Execute(int[] array) {
        var max = 0;

        for (var number : array){
            if (number > max){
                max = number;
            }
        }

        System.out.println("Max: " + max);
    }
}
