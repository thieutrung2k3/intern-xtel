package Thriority;

class MyPriorityThread extends Thread {
    public MyPriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(this.getName() + " is running: " + i);
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        MyPriorityThread low = new MyPriorityThread("Low Priority Thread");
        MyPriorityThread normal = new MyPriorityThread("Normal Priority Thread");
        MyPriorityThread high = new MyPriorityThread("High Priority Thread");

        // Thiết lập độ ưu tiên
        low.setPriority(Thread.MIN_PRIORITY);       // 1
        normal.setPriority(Thread.NORM_PRIORITY);   // 5
        high.setPriority(Thread.MAX_PRIORITY);      // 10

        // Khởi động các thread
        low.start();
        normal.start();
        high.start();
    }
}

