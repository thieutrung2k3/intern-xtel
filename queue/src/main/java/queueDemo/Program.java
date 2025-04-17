package queueDemo;

import java.util.*;
import java.util.concurrent.DelayQueue;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new ArrayDeque<>();
        Queue<Integer> queue4 = new PriorityQueue<>();

        Deque<Integer> queue33 = new ArrayDeque<>();
        DelayQueue<Animal> queue3 = new DelayQueue<>();

        queue3.offer(new Animal("Lion", 5));
        queue3.offer(new Animal("Tiger", 2));
        queue3.offer(new Animal("Chicken", 3));
        queue3.offer(new Animal("Bird", 6));
        queue3.offer(new Animal("Dog", 1));
        queue3.offer(new Animal("Mouse", 3));

        while(!queue3.isEmpty()){
            Animal animal = queue3.take();
            System.out.println(animal.getName());
        }



    }
}
