package time;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("Task chạy mỗi 1 giây");
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // chạy sau 0ms, lặp mỗi 1000ms
    }
}
