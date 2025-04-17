package multithreading;

class MyThread extends Thread {
    private String threadName;

    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DemoThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Luồng A");
        MyThread t2 = new MyThread("Luồng B");

        t1.start();
        t2.start();
    }
}

