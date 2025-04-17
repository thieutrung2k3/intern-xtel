package customerLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomLogger {
    // Log levels
    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    
    private static int currentLogLevel = INFO; // Default log level
    private static String logFilePath = "application.log"; // Default log file
    private static boolean consoleOutput = true; // Whether to output logs to console
    
    public static void setLogLevel(int level) {
        currentLogLevel = level;
    }
    
    public static void setLogFile(String filePath) {
        logFilePath = filePath;
    }
    
    public static void setConsoleOutput(boolean enabled) {
        consoleOutput = enabled;
    }
    
    public static void debug(String message) {
        log(DEBUG, message);
    }
    
    public static void info(String message) {
        log(INFO, message);
    }
    
    public static void warning(String message) {
        log(WARNING, message);
    }
    
    public static void error(String message) {
        log(ERROR, message);
    }
    
    private static void log(int level, String message) {
        if (level < currentLogLevel) {
            return; // Skip if below current log level
        }
        
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String levelStr = getLevelString(level);
        String logMessage = String.format("[%s] %s: %s", timestamp, levelStr, message);
        
        // Print to console if enabled
        if (consoleOutput) {
            System.out.println(logMessage);
        }
        
        // Write to log file
        try (FileWriter fw = new FileWriter(logFilePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(logMessage);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
    
    private static String getLevelString(int level) {
        switch (level) {
            case DEBUG: return "DEBUG";
            case INFO: return "INFO";
            case WARNING: return "WARNING";
            case ERROR: return "ERROR";
            default: return "UNKNOWN";
        }
    }
    
    // Example usage
    public static void main(String[] args) {

        
        // Change log level to see only warnings and errors
        CustomLogger.setLogLevel(WARNING);
        CustomLogger.debug("This debug won't be logged");
        CustomLogger.info("This info won't be logged");
        CustomLogger.warning("This warning will be logged");
        CustomLogger.error("This error will be logged");
    }
}