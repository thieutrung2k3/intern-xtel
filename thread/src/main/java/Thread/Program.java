package Thread;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread chạy bằng cách kế thừa Thread");
    }
}

public class Program {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
