package unlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEx {
    private final Map<String, String> map = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, String value){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " - put " + key + " -> " + value);
            Thread.sleep(5000);
            map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " - unlock");
        }
    }

    public String get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " - get " + key);
            Thread.sleep(1000);
            return map.get(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " - unlock");
        }
    }

    public static void main(String[] args) {
        ReadWriteLockEx cache = new ReadWriteLockEx();

        // Writer threads
        Thread writer1 = new Thread(() -> {
            cache.put("key1", "value1");
            cache.put("key2", "value2");
        }, "Writer-1");

        Thread writer2 = new Thread(() -> {
            cache.put("key3", "value3");
            cache.put("key4", "value4");
        }, "Writer-2");

        // Reader threads
        Thread reader1 = new Thread(() -> {
            cache.get("key1");
            cache.get("key2");
        }, "Reader-1");

        Thread reader2 = new Thread(() -> {
            cache.get("key3");
            cache.get("key4");
        }, "Reader-2");

        writer1.start();
        reader1.start();
        writer2.start();
        reader2.start();

    }

}
