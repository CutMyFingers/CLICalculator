package com.cli.rpn.calculator.interfaces.impl;

import com.cli.rpn.calculator.interfaces.Processor;

public class ProcessorSubtractImpl implements Processor {

    @Override
    public Double process(Double a, Double b) {
        return a - b;
    }
}
