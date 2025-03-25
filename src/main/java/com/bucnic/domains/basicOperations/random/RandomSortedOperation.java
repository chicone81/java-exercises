package com.bucnic.domains.basicOperations.random;

import com.bucnic.domains.basicOperations.map.StatefulOperation;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSortedOperation implements StatefulOperation<Integer,String> {
    private final int MAX_NUMBER = 100;
    private String result;

    @Override
    public void execute(Integer numberToGenerate) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numberToGenerate; i++){
            numbers.add(ThreadLocalRandom.current().nextInt(MAX_NUMBER));
        }

        Collections.sort(numbers);

        for (var number : numbers){
            stringBuilder.append(number)
                    .append(System.lineSeparator());
        }

        result = stringBuilder.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
