package com.cli.rpn.calculator.business.interfaces.impl;

import com.cli.rpn.calculator.business.interfaces.ICalculator;

public class CalculatorAddImpl implements ICalculator {

    @Override
    public Double compute(Double a, Double b) {
        return a + b;
    }
}
