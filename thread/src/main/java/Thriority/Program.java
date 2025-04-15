package Thriority;

public class Program {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(i);
            }
        });
        Thread t2 = new Thread(() -> System.out.println("Low priority"));

        t1.setPriority(Thread.MAX_PRIORITY);  // 10
        t2.setPriority(Thread.MIN_PRIORITY);  // 1

        t1.start();
        t2.start();

    }
}
