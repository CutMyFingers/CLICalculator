
package com.cli.rpn.calculator.business;

import com.cli.rpn.calculator.business.utils.ConsoleReader;

import static com.cli.rpn.calculator.business.utils.ConsoleReader.readLineFromConsole;

public class ConsoleEngine {

    // Reads data from console line by line and processes it
    public static void run() {
        ConsoleProcessor cp = new ConsoleProcessor();
        final String exitKey = "q";

        // Works until a user enters 'q'
        String data = readLineFromConsole();
        while (!data.equals(exitKey)) {
            cp.process(data);
            data = readLineFromConsole();
        }
    }
}
