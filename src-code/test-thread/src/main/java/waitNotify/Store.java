package waitNotify;

public class Store {
    private int count = 0;
    private boolean isFull = false;

    public synchronized void increment() throws InterruptedException {
        while (isFull) {
            System.out.println("Store is full, waiting...");
            wait();
        }
        Thread.sleep(1000);
        count++;
        System.out.println("Store inc: " + count);
        isFull = true;
        notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (!isFull) {
            System.out.println("Store is empty, waiting...");
            wait();
        }
        Thread.sleep(1000);
        count--;
        System.out.println("Store dec: " + count);
        isFull = false;
        notifyAll();
    }
}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                store.increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                store.decrement();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
