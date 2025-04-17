package threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            Runnable task = () -> {
                System.out.println("Task " + taskId + " đang chạy trong " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
            };
            executor.execute(task);
        }

        executor.shutdown();
    }
}
