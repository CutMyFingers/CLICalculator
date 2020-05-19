
package com.cli.rpn.calculator.business;

import static com.cli.rpn.calculator.business.utils.ConsoleReader.readLineFromConsole;

public class ConsoleEngine {

    public static void run() {
        final String exitKey = "q";
        String data = readLineFromConsole();
        ConsoleProcessor cp = new ConsoleProcessor();

        // Works until a user enters 'q'
        while (!data.equals(exitKey)) {
            cp.process(data);
            data = readLineFromConsole();
        }
    }
}
