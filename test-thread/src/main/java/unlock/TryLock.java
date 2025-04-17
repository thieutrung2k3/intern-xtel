package unlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment(){
        try{
            //Neu ko dc unlock, sau 6s se dung thread
            if(lock.tryLock(6, TimeUnit.SECONDS)){
                try{
                    for(int i = 0; i < 10; i++){
                        count++;
                        System.out.printf(Thread.currentThread().getName() + " - Count: %d\n", count);
                        Thread.sleep(500);
                    }
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }finally{
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "unlock");
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " - Lock failed");
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TryLock tryLock = new TryLock();
        Thread thread1 = new Thread(() -> {
            tryLock.increment();
        }, "Thread-1"
        );
        Thread thread2 = new Thread(() -> {
            tryLock.increment();
        }, "Thread-2"
        );
        thread2.start();
        thread1.start();
    }
}
