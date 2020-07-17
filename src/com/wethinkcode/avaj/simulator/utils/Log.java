package com.wethinkcode.avaj.simulator.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class Log {
    private final static Logger logger = Logger.getLogger(Log.class.getName());
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
            logger.log(Level.SEVERE, SIMULATION_FILE, new RuntimeException(ERROR_WRITING_FILE));
            System.exit(1);
        }
    }

    public static void addMessage(String message) {
        messages.add(message);
    }
}
