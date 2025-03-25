package com.bucnic.domains.basicOperations.random;

import com.bucnic.domains.basicOperations.map.StatefulOperation;
import com.bucnic.domains.basicOperations.interfaces.InputHandler;
import com.bucnic.domains.basicOperations.interfaces.OutputHandler;

import java.util.List;

public class RandomService {

    private final List<StatefulOperation<Integer,String>> operations;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RandomService(InputHandler inputHandler, OutputHandler outputHandler,
                         List<StatefulOperation<Integer,String>> operations) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.operations = operations;
    }

    public void Process(){
        this.outputHandler.writeLine("Insert the max number to randomize");
        int numberToGenerate;
        try{
            numberToGenerate = Integer.parseInt(this.inputHandler.readStrings());
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        StringBuilder operationResult = new StringBuilder();

        for (var operation : operations){
            operation.execute(numberToGenerate);
        }

        for (var operation : operations){
            operationResult.append(operation.getClass().getSimpleName())
                    .append(": ")
                    .append(System.lineSeparator())
                    .append(operation.getResult());
        }

        this.outputHandler.writeLine(operationResult.toString());
    }
}
