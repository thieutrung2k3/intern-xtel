import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MsgQueue {
    private final BlockingQueue<Integer> queue;

    public MsgQueue(int size){
        this.queue = new ArrayBlockingQueue<>(size);
    }

    public void produce() throws InterruptedException {
        int msg = 0;
        while(true){
            //De sleep 1s
            Thread.sleep(1000);
            System.out.println("Producer create msg: " + msg);
            queue.put(msg);
            msg++;
        }
    }

    public void consumer() throws InterruptedException {
        while (true){
            Thread.sleep(2000);
            int msg = queue.take();
            System.out.println("Consumer get msg: " + msg);
        }
    }

}
