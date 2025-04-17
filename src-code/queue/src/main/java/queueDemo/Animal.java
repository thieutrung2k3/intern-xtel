package queueDemo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Animal implements Delayed {
    private final String name;
    private final long startTime;

    public Animal(String name, long startTime){
        this.name = name;
        this.startTime = startTime * 1000 + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long time = startTime - System.currentTimeMillis();
        return unit.convert(time, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }

    public String getName() {
        return name;
    }
}
