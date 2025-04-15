package runnable;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread chạy bằng Runnable");
    }
}

public class Program {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

