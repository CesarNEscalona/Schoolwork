package driver;

import consumer.Consumer;
import producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {

    public static void main(String[] args) throws InterruptedException {

        // construct the BlockingQueue
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        // create 10 Producer Threads
        Thread[] producers = new Thread[10];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(queue, i));
            producers[i].start();
            // main thread wait
            producers[i].join();
        }

        // create 50 Consumer Threads
        Thread[] consumers = new Thread[50];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(queue, i));
            consumers[i].start();
            // main thread wait
            consumers[i].join();
        }

        // Here all threads should have work completed because of join
        System.out.println(queue.size());
    }
}