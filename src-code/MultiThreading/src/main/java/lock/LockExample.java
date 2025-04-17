package lock;

import java.util.concurrent.locks.*;

class LockCounter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return count;
    }
}

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        LockCounter counter = new LockCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Giá trị đếm cuối cùng: " + counter.getValue());
    }
}
