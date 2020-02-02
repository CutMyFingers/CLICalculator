package com.cli.rpn.calculator.interfaces.impl;

import com.cli.rpn.calculator.interfaces.Processor;

public class ProcessorDivideImpl implements Processor {

    @Override
    public Double process(Double a, Double b) {
        return a / b;
    }
}
