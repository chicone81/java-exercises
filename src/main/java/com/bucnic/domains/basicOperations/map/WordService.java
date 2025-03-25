package com.bucnic.domains.basicOperations.map;

import com.bucnic.domains.basicOperations.interfaces.InputHandler;
import com.bucnic.domains.basicOperations.interfaces.OutputHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordService {
    private final InputHandler inputHandler;
    private final String separator;
    private final StatefulOperation<List<String>,HashMap<String,Integer>> operation;
    private final OutputHandler outputHandler;

    public WordService(InputHandler inputHandler, String separator,
                       OutputHandler outputHandler,
                       StatefulOperation<List<String>,HashMap<String,Integer>> operation) {
        this.inputHandler = inputHandler;
        this.separator = separator;
        this.operation = operation;
        this.outputHandler = outputHandler;
    }

    public void Process(){
        this.outputHandler.writeLine("insert a lot words separated by space");

        String line = this.inputHandler.readStrings();
        var input = Arrays.asList(line.split(separator));

        operation.execute(input);
        var operationResult = operation.getResult();

        this.outputHandler.writeLine("Operation results: ");
        operationResult.forEach((word,count) -> outputHandler.writeLine(word + " -> " + count));
    }
}
