package com.cli.rpn.calculator.business;

import com.cli.rpn.calculator.business.utils.CalculatorHelper;
import com.cli.rpn.calculator.business.interfaces.ICalculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.System.out;

public class ConsoleProcessor {

    private Deque<Double> numbersStack = new ArrayDeque<>();
    private Pattern numericRegex = Pattern.compile("-?\\d+(\\.\\d+)?");

    public void process(String data) {
        if (data == null) return;

        boolean isNumeric = numericRegex.matcher(data)
                .matches();
        if (isNumeric) {
            processNumeric(data);
        } else {
            processOperation(data);
        }
    }

    // Adds number to stack
    private void processNumeric(String data) {
        Double number = parseDouble(data);
        numbersStack.push(number);
        out.println(number);
    }

    // Uses two last numbers from stack for calculation.
    private void processOperation(String data) {
        ICalculator calculator = CalculatorHelper.getCalculatorImpl(data);
        if (calculator == null) {
            out.println(data + " operation is not supported!");
            return;
        }

        try {
            // Checks if there are enough numbers for calculation
            if (numbersStack.size() > 1) {
                Double a = numbersStack.pop();
                Double b = numbersStack.pop();
                Double result = calculator.compute(b, a);

                numbersStack.push(result);
                out.println(result);
            } else {
                out.println("There are less than two numbers for processing.");
            }
        } catch (NoSuchElementException e) {
            out.println("There are no numbers for processing!");
        }
    }
}
