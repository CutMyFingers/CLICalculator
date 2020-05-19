package com.cli.rpn.calculator;

import com.cli.rpn.calculator.business.ConsoleEngine;
import com.cli.rpn.calculator.business.utils.ConsoleReader;

public class Main {

    public static void main(String[] args) {
        ConsoleEngine.run(); // Run business logic
        ConsoleReader.closeReader(); // Close Scanner
    }

}
