package waitNotify;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerExample {
    private static final int MAX_SIZE = 10;  // Kích thước tối đa của queue
    private final Queue<Integer> queue = new LinkedList<>();  // Queue dùng để lưu dữ liệu
    private final Object lock = new Object();  // Object dùng để đồng bộ hóa

    public void produce() throws InterruptedException {
        synchronized (lock) {
            // 1. Kiểm tra xem queue có đầy không
            while(queue.size() == MAX_SIZE) {
                System.out.println("Queue is full, waiting...");
                lock.wait();  // Producer sẽ đợi nếu queue đầy
            }
        
            // 2. Thêm số ngẫu nhiên vào queue
            int num = new Random().nextInt(100);
            queue.add(num);
            System.out.println("Producer: " + num);
        
            // 3. Thông báo cho Consumer biết có dữ liệu mới
            lock.notifyAll();
        }
    }

private void consume() throws InterruptedException {
    synchronized (lock) {
        // 1. Kiểm tra xem queue có trống không
        while(queue.isEmpty()) {
            System.out.println("Queue is empty, waiting...");
            lock.wait();  // Consumer sẽ đợi nếu queue trống
        }
        
        // 2. Lấy và xử lý dữ liệu từ queue
        int num = queue.remove();
        System.out.println("Consumer: " + num);
        
        // 3. Thông báo cho Producer biết đã có chỗ trống
        lock.notifyAll();
    }
}

    public static void main(String[] args) {
        ProducerConsumerExample producerConsumer = new ProducerConsumerExample();
        Thread producer = new Thread(() -> {
            try {
                for(int i = 0; i < 10; i++){
                    producerConsumer.produce();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for(int i = 0; i < 10; i++){
                    producerConsumer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }
}