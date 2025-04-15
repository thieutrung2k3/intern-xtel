package waitNotify;

class SharedData {
    private boolean dataAvailable = false;

    public synchronized void produce() {
        try {
            while (dataAvailable) {
                wait();
            }
            System.out.println("Tạo dữ liệu...");
            dataAvailable = true;
            notify();
        } catch (InterruptedException e) {}
    }

    public synchronized void consume() {
        try {
            while (!dataAvailable) {
                wait();
            }
            System.out.println("Tiêu thụ dữ liệu");
            dataAvailable = false;
            notify();
        } catch (InterruptedException e) {}
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Thread producer = new Thread(() -> {
            while (true) {
                data.produce();
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                data.consume();
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
