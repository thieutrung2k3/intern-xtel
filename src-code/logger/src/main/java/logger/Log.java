package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private String fileName;

    public Log(String fileName){
        this.fileName = fileName;
    }

    private void log (String level, String msg){
        try(FileWriter writer = new FileWriter(fileName, true);){

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("[" + timestamp + "] [" + level + "] " + msg + "\n");
            writer.write("[" + timestamp + "] [" + level + "] " + msg + "\n");
        } catch (IOException e) {
            System.err.println("Không thể ghi log: " + e.getMessage());
        }
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void warn(String message) {
        log("WARN", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    public void debug(String message) {
        log("DEBUG", message);
    }
}
