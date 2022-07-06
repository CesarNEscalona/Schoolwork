package consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<String> queue;
    private int id;

    public Consumer(BlockingQueue<String> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run(){
        try {
            //remove items in the queue
            String item = queue.take();
            System.out.println("Consumer " + id + " takes item " + item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}