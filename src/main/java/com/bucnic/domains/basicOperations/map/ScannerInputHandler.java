package com.bucnic.domains.basicOperations.map;

import com.bucnic.domains.basicOperations.interfaces.InputHandler;

import java.util.Scanner;

public class ScannerInputHandler implements InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readStrings() {
        return scanner.nextLine();
    }

//    @Override
//    public void close(){
//        scanner.close();
//    }
}
