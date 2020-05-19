package com.cli.rpn.calculator.business.utils;

import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleReader {
    private final static Scanner reader = new Scanner(System.in);

    public static String readLineFromConsole() {
        out.print('>'); // For more convenient input
        return reader.next();
    }

    public static void closeReader() {
        reader.close();
    }
}
