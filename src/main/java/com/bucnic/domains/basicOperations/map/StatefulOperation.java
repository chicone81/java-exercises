package com.bucnic.domains.basicOperations.map;

public interface StatefulOperation<I,O> {
    void execute(I input);
    O getResult();
}
