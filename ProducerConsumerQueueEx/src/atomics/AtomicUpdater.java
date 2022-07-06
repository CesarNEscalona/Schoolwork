package atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicUpdater {

    private AtomicInteger data;

    public AtomicUpdater(int num) {
        this.data = new AtomicInteger(num);
    }

    public void increment(){
        // returns the new value, but we'll ignore the returned value
        data.incrementAndGet();
    }

    public int getData(){
        return data.get();
    }

    public static void main(String[] args) throws InterruptedException{
        AtomicUpdater updater = new AtomicUpdater(0);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread( new Runnable() {
                public void run(){
                    for (int j = 1; j <= 10000; j++) {
                        updater.increment();
                    }
                }
            });

        }
        // start all threads
        for (Thread thread : threads) { thread.start(); }

        // wait until the threads complete
        for(Thread thread : threads) { thread.join(); }

        System.out.println("Final number: " + updater.getData());
    }
}
