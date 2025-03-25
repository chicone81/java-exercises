package com.bucnic.domains.basicOperations.random;

import com.bucnic.domains.basicOperations.map.StatefulOperation;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUniqueOperation implements StatefulOperation<Integer,String> {
    private String result;

    @Override
    public void execute(Integer numberToGenerate) {
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < numberToGenerate){
            int MAX_NUMBER = 100;
            int number = ThreadLocalRandom.current().nextInt(MAX_NUMBER);
            uniqueNumbers.add(number);
        }

        for (var number : uniqueNumbers)
        {
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
