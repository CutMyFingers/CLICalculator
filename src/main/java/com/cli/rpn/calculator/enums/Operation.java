package com.cli.rpn.calculator.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.cli.rpn.calculator.interfaces.Processor;
import com.cli.rpn.calculator.interfaces.impl.ProcessorAddImpl;
import com.cli.rpn.calculator.interfaces.impl.ProcessorSubtractImpl;
import com.cli.rpn.calculator.interfaces.impl.ProcessorDivideImpl;
import com.cli.rpn.calculator.interfaces.impl.ProcessorMultiplyImpl;

public enum Operation {

        /*
         * Each field holds an operation key and its process implementation
         * class (e.g addition, subtraction so on) that will be executed.
         */
        ADDITION("+", new ProcessorAddImpl()),
        SUBTRACTION("-", new ProcessorSubtractImpl()),
        DIVISION("/", new ProcessorDivideImpl()),
        MULTIPLICATION("*", new ProcessorMultiplyImpl());

    private static final Map<String, Operation> lookup = new HashMap<>();

    static {
        for (Operation operation : EnumSet.allOf(Operation.class)) {
            if (Objects.nonNull(operation.getKey())) {
                lookup.put(operation.getKey(), operation);
            }
        }
    }

    private String key;
    private Processor processor;

    Operation(String key, Processor actor) {
        this.key = key;
        this.processor = actor;
    }

    public String getKey() {
        return this.key;
    }

    public Processor getProcessor() {
        return this.processor;
    }

    public static boolean isOperation(String key) {
        return lookup.containsKey(key);
    }

    public static Operation get(String key) {
        return lookup.get(key);
    }
}
