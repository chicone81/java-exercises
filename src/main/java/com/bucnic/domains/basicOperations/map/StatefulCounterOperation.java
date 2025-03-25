package com.bucnic.domains.basicOperations.map;

import java.util.HashMap;
import java.util.List;

public class StatefulCounterOperation implements StatefulOperation<List<String>,HashMap<String,Integer>> {

    private final HashMap<String, Integer> result = new HashMap<>();

    @Override
    public void execute(List<String> words) {
        for (var word : words){
            this.result.put(word,this.result.getOrDefault(word,0) + 1);
        }
    }

    @Override
    public HashMap<String, Integer> getResult() {
        return this.result;
    }
}
