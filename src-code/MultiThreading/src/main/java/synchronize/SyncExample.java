package synchronize;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getValue() {
        return count;
    }
}

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

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

