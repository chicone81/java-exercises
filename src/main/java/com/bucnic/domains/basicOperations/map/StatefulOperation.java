package com.bucnic.domains.basicOperations.map;

import java.util.List;

public interface StatefulOperation<I,O> {
    void execute(I input);
    O getResult();
}
