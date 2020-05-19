package com.cli.rpn.calculator.business.utils;

import com.cli.rpn.calculator.business.interfaces.ICalculator;
import com.cli.rpn.calculator.business.interfaces.impl.CalculatorAddImpl;
import com.cli.rpn.calculator.business.interfaces.impl.CalculatorDivideImpl;
import com.cli.rpn.calculator.business.interfaces.impl.CalculatorMultiplyImpl;
import com.cli.rpn.calculator.business.interfaces.impl.CalculatorSubtractImpl;

import java.util.HashMap;
import java.util.Map;

public class CalculatorHelper {

    private static Map<String, ICalculator> calculatorImpls;

    // Add basic operations
    static {
        calculatorImpls = new HashMap() {
            {
                put("+", new CalculatorAddImpl());
                put("-", new CalculatorSubtractImpl());
                put("/", new CalculatorDivideImpl());
                put("*", new CalculatorMultiplyImpl());
            }
        };
    }

    public static ICalculator getCalculatorImpl(String operation) {
        return calculatorImpls.get(operation);
    }

    public static void addCalculatorImpl(String operation, ICalculator calcImpl) {
        calculatorImpls.put(operation, calcImpl);
    }
}
