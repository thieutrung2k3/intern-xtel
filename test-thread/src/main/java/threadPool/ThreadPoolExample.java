package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

    public class ThreadPoolExample {
    public static void main(String[] args) {
        // Tạo cached thread pool
        ExecutorService executor = Executors.newCachedThreadPool();
        
        // Submit nhiều task với độ trễ
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task #" + taskId + " bắt đầu bởi thread " + 
                                 Thread.currentThread().getName());
                try {
                    // Task đầu tiên sẽ mất nhiều thời gian hơn
                    if (taskId == 1) {
                        Thread.sleep(3000);
                    } else {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task #" + taskId + " kết thúc bởi thread " + 
                                 Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}