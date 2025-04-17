package queue;

import java.util.concurrent.*;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        Runnable producer = () -> {
            int i = 1;
            try {
                while (true) {
                    System.out.println("Producer tạo: " + i);
                    queue.put(i++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable consumer = () -> {
            try {
                while (true) {
                    int value = queue.take();
                    System.out.println("Consumer lấy: " + value);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

