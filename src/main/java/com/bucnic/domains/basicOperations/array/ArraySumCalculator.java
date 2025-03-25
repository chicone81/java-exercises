package com.bucnic.domains.basicOperations.array;

public class ArraySumCalculator implements ArrayOperation {
    @Override
    public void Execute(int[] array) {
        var sum = 0;

        for (var number : array){
            sum += number;
        }

        System.out.println("Sum: " + sum);
    }
}
