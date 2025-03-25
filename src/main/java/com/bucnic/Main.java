package com.bucnic;

import com.bucnic.domains.basicOperations.array.*;
import com.bucnic.domains.basicOperations.Calculator;
import com.bucnic.domains.basicOperations.Exercise;
import com.bucnic.domains.basicOperations.map.*;
import com.bucnic.domains.basicOperations.StringConcatenator;
import com.bucnic.domains.basicOperations.random.RandomClassicOperation;
import com.bucnic.domains.basicOperations.random.RandomService;
import com.bucnic.domains.basicOperations.random.RandomSortedOperation;
import com.bucnic.domains.basicOperations.random.RandomUniqueOperation;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var loop = true;

        while (loop){
            System.out.println(GetExercises());
            System.out.println("Choose exercise " + System.lineSeparator());

            int input;
            try {
                input = scanner.nextInt();
                scanner.nextLine();

                switch (Exercise.fromValue(input)){
                    case Calculator:
                        SumExercise(scanner);
                        break;
                    case StringConcatenate:
                        ConcatenateExercise(scanner);
                        break;
                    case Array:
                        ArrayOperations(scanner);
                        break;
                    case Map:
                        MapOccurrences();
                        break;
                    case Random:
                        RandomizeNumbers();
                        break;
                    case null:
                        System.out.println("Bye!");
                        loop = false;
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Wrong value!");
                scanner.nextLine();
            }
        }
    }

    private static String GetExercises(){
        StringBuilder response = new StringBuilder();
        response.append(System.lineSeparator())
                .append("Exercises: ").append(System.lineSeparator());
        response.append("0" + ") " + "Quit")
                .append(System.lineSeparator());

        for (var exercise : Exercise.values()){
            response.append(exercise.getValue())
                    .append(") ")
                    .append(exercise.getDescription())
                    .append(System.lineSeparator());
        }

        return response.toString();
    }

    /// Exercises
    //  *****************************************************************

    private static void SumExercise(Scanner scanner) {
        Calculator calculator = new Calculator();

        System.out.print("Insert a number: ");
        calculator.setA(scanner.nextInt());
        System.out.print("Insert another number: ");
        calculator.setB(scanner.nextInt());

        System.out.println("Sum of " + calculator.getA() + " and " + calculator.getB() +
                " is " + calculator.Sum());
    }

    private static void ConcatenateExercise(Scanner scanner) {

        StringConcatenator stringConcatenator = new StringConcatenator();
        System.out.println("Insert first string: ");
        var a = scanner.nextLine();
        System.out.println("Insert second string: ");
        var b = scanner.nextLine();
        System.out.println(stringConcatenator.Concatenate(a,b));
    }

    private static void ArrayOperations(Scanner scanner) {
        System.out.println("insert a lot of integer numbers separated by space");
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        List<ArrayOperation> operations = List.of(
                new ArrayPrinter(),
                new ArraySumCalculator(),
                new ArrayFindMax());
        ArrayProcessor arrayProcessor = new ArrayProcessor(operations);
        arrayProcessor.process(numbers);
    }

    private static void MapOccurrences() {
        var input = new ScannerInputHandler();
        final var separator = " ";
        var operation = new StatefulCounterOperation();
        var output = new ConsoleOutputHandler();

        var wordService = new WordService(input, separator, output, operation);
        wordService.Process();
    }

    private static void RandomizeNumbers() {
        var input = new ScannerInputHandler();
        var output = new ConsoleOutputHandler();
        var operations = new ArrayList<StatefulOperation<Integer, String>>();
        operations.add(new RandomClassicOperation());
        operations.add(new RandomUniqueOperation());
        operations.add(new RandomSortedOperation());

        var randomService = new RandomService(input, output, operations);
        randomService.Process();
    }


    // *****************************************************************
}