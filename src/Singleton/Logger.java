package Singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;

    private File logFile = null;
    private BufferedWriter writer = null;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String filename) {
        close();

        try {
            logFile = new File(filename);

            if (!logFile.exists()) {
                if (!logFile.createNewFile()) {
                    System.out.println("Failed to create a new file.");
                    logFile = null;
                    return;
                }
            }

            writer = new BufferedWriter(new FileWriter(logFile, true));

        } catch (IOException e) {
            System.out.println("An error occurred while creating the log file.");
            e.printStackTrace();
            logFile = null;
            writer = null;
        }
    }

    public void write(String message) {
        System.out.println("[LOG]: " + message);

        if (writer == null) {
            System.out.println("No log file has been set.");
            return;
        }

        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }

    public void close() {
        if (writer == null) {
            logFile = null;
            return;
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while closing the log file.");
            e.printStackTrace();
        } finally {
            writer = null;
            logFile = null;
        }
    }
}
