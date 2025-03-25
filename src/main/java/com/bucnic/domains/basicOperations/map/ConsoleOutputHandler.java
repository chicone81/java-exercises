package com.bucnic.domains.basicOperations.map;

import com.bucnic.domains.basicOperations.interfaces.OutputHandler;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }
}
