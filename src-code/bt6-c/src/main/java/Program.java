public class Program {
    public static void main(String[] args) {
        MsgQueue msgQueue = new MsgQueue(5);

        Thread producerThread = new Thread(() ->{
            try {
                msgQueue.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(()->{
            try{
                msgQueue.consumer();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
