
package com.cli.rpn.calculator;

import static com.cli.rpn.calculator.enums.Operation.isOperation;
import static java.lang.Double.parseDouble;
import static java.lang.System.out;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cli.rpn.calculator.enums.Operation;

public class Engine {

    private Pattern numericRegex = Pattern.compile("-?\\d+(\\.\\d+)?");

    // Is used to hold numbers.
    private Deque<Double> stack = new ArrayDeque<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // For the better appearance of an input
        out.print('>');
        String input = scanner.next();

        while (!input.equals("q")) {
            processIfNumeric(input);

            // For the better appearance of an input
            out.print('>');
            input = scanner.next();
        }

        scanner.close();
    }

    private void processIfNumeric(String input) {
        if (isNumeric(input)) {
            Double number = parseDouble(input);

            out.println(number);
            stack.push(number);
            return;
        }
        processIfOperation(input);
    }

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return numericRegex.matcher(str)
            .matches();
    }

    private void processIfOperation(String input) {
        try {
            if (isOperation(input)) {
                /*
                 * Checks if there are enough numbers for processing in the
                 * stack.
                 */
                if (stack.size() > 1) {
                    Double secondNum = stack.pop();
                    Double firstNum = stack.pop();
                    Operation operation = Operation.get(input);

                    // Processing two numbers depending on the operation.
                    Double result = operation.getProcessor()
                        .process(firstNum, secondNum);

                    stack.push(result);
                    out.println(result);
                } else {
                    out.println("There are less than two numbers for processing.");
                }

            } else {
                out.println(String.format("%s operation is not supported!", input));
            }
        } catch (NoSuchElementException e) {
            out.println("There are no numbers for processing!");
        }
    }
}
