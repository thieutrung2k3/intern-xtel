package time;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//                System.out.println("Task chạy mỗi 1 giây");
//            }
//        };
//
//        timer.scheduleAtFixedRate(task, 0, 1000); // chạy sau 0ms, lặp mỗi 1000ms
        ScheduledExecutorService shService = Executors.newScheduledThreadPool(5);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task start.");
                for(int i = 0; i < 10; i++){
                    System.out.print(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("Task stop.");
                System.out.println();
            }
        };


        shService.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);


    }
}
