package unlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Program {
    private ReentrantLock lock = new ReentrantLock();
    int count = 0;

    public void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                count++;
                Thread.sleep(500);
                System.out.printf("Count: " + count + " by thread: " + Thread.currentThread().getName() + "\n");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Program program = new Program();

        Thread thread1 = new Thread(() -> {
            program.increment();
        }, "Thread-1"
        );
        Thread thread2 = new Thread(() -> {
            program.increment();
        }, "Thread-2"
        );
        thread2.start();
        thread1.start();
    }
}
