package producer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<String> queue;
    private int id;

    public Producer(BlockingQueue<String> queue, int id){
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run(){
        try {
        for (int i = 0; i < 5; i++) {
            // Place things in the queue

            queue.put("Producer " + id + " places item #" + i);
        }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }