package com.wethinkcode.avaj.simulator.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

/**
 * Log
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public class Log {
    public static List<String> messages = new ArrayList<>();

    public static void logMessage() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SIMULATION_FILE));
            for(String message: messages){
                bufferedWriter.write(message);
                bufferedWriter.append('\n');
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(ERROR_WRITING_FILE);
            System.exit(1);
        }
    }

    public static void addMessage(String message) {
        messages.add(message);
    }
}
