package logger;

public class Program {
    public static void main(String[] args) {
        Log log = new Log("app.txt");

        log.warn("This is warn msg.");
        log.debug("This is debug msg");
        log.error("This is error msg");
        log.info("This is info msg");
    }
}
