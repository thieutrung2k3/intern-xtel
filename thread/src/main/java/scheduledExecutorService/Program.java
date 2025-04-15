package scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable task = new Runnable() {
            int count = 0;

            public void run() {
                System.out.println("Đồng hồ (executor): " + ++count + " giây");
                if (count >= 5) {
                    scheduler.shutdown(); // Dừng sau 5 lần
                }
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
