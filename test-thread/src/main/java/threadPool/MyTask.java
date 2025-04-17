package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Cập nhật lớp MyTask để in thông tin chi tiết hơn
class MyTask implements Runnable {
    private int id;
    
    public MyTask(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        System.out.println("Task #" + id + " đang được thực thi bởi thread " + 
                          Thread.currentThread().getName());
        try {
            // Giả lập công việc mất 2 giây
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task #" + id + " đã hoàn thành");
    }
}