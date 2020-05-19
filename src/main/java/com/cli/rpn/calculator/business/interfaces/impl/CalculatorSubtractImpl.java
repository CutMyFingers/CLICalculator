package com.cli.rpn.calculator.business.interfaces.impl;

import com.cli.rpn.calculator.business.interfaces.ICalculator;

public class CalculatorSubtractImpl implements ICalculator {

    @Override
    public Double compute(Double a, Double b) {
        return a - b;
    }
}
