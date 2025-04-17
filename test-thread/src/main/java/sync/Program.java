package sync;

public class Program {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {

            count++;

    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Program program = new Program();
        Thread thread1 = new Thread(() -> {
            synchronized (program.lock) {
                for (int i = 0; i < 10000; i++) {
                    System.out.printf("\nThread #1 - Count: %d", i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    program.increment();
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            synchronized (program.lock) {
                for (int i = 0; i < 10000; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("\nThread #2 - Count: %d", i);
                    program.increment();
                }}

        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + program.getCount());

    }
}
