package com.bucnic.domains.basicOperations.random;

import com.bucnic.domains.basicOperations.map.StatefulOperation;
import java.util.concurrent.ThreadLocalRandom;

public class RandomClassicOperation implements StatefulOperation<Integer,String> {
    private String result;

    @Override
    public void execute(Integer numberToGenerate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberToGenerate; i++){
            int MAX_NUMBER = 100;
            int number = ThreadLocalRandom.current().nextInt(MAX_NUMBER);
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
