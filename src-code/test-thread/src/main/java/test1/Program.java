package test1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Program {
    public static void main(String[] args) {
        String[] nameArr = {"Nguyen Ngoc Lan","Duong Tien Nam","Ngo Anh Quan","Pham Van Duc","Tran Thi Ha"};
        String[] addArr = {"Hải Phòng","Hà Nội","Thái Nguyên","Hà Tĩnh","Quảng Ninh"};
        AtomicBoolean namePrinted = new AtomicBoolean(false);
        Object lock = new Object();

        Thread nameThread = new Thread(() -> {
            Arrays.stream(nameArr).forEach(s -> {
                synchronized (lock){
                    while(namePrinted.get()){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Name: " + s);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    namePrinted.set(true);
                    lock.notifyAll();
                }
            });
        });

        Thread addThread = new Thread(() -> {
            Arrays.stream(addArr).forEach(s -> {
                synchronized (lock){
                    while(!namePrinted.get()){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Address: " + s);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    namePrinted.set(false);
                    lock.notifyAll();
                }
            });
        });

        nameThread.start();
        addThread.start();

    }
}
