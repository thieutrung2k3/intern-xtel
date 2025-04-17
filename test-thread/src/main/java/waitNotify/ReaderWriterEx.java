package waitNotify;

public class ReaderWriterEx {
    private int readers = 0;
    private boolean isWriting = false;
    private final Object lock = new Object();
    private int data = 0;

    public void read(){
        synchronized (lock){
            try{
                while(isWriting){
                    System.out.println(Thread.currentThread().getName()+" is waiting to read.");
                    lock.wait();
                }
                readers++;
                System.out.println(Thread.currentThread().getName() + " is reading data: " + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                readers--;
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + " is done reading.");
            }
        }
    }

    public void write(int newData){
        synchronized (lock){
            try{
                while(readers > 0 || isWriting){
                    System.out.println(Thread.currentThread().getName() + " is waiting to write.");
                    lock.wait();
                }
                isWriting = true;
                System.out.println(Thread.currentThread().getName() + " is writing data: " + newData);
                data = newData;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                isWriting = false;
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + " is done writing.");
            }
        }
    }

    public static void main(String[] args) {
        ReaderWriterEx example = new ReaderWriterEx();

        // 3 readers
        for (int i = 1; i <= 3; i++) {
            final String name = "Reader-" + i;
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    example.read();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, name).start();
        }

        // 2 writers
        for (int i = 1; i <= 2; i++) {
            final String name = "Writer-" + i;
            final int writerNum = i;
            new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    example.write(writerNum * 10 + j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, name).start();
        }

    }
}
