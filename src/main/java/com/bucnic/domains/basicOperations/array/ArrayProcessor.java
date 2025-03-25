package com.bucnic.domains.basicOperations.array;

import java.util.List;

public class ArrayProcessor {
    private final List<ArrayOperation> operations;

    public ArrayProcessor(List<ArrayOperation> operations){
        this.operations = operations;
    }

    public void process(int[] array){
        for (var operation : operations) {
            operation.Execute(array);
        }
    }
}
