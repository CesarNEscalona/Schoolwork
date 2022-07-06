package threadsafety;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        SharedData sharedData = new SharedData();

        final int NUM_THREADS = 5;

        // create add threads
        Thread[] addThreads = new Thread[NUM_THREADS];
        for (int i = 0; i < addThreads.length; i++) {
            addThreads[i] = new Thread(new Adder(sharedData));
        }

        // create remove threads
        //Thread[] removeThreads = new Thread[NUM_THREADS];
        //for (int i = 0; i < removeThreads.length; i++) {
            //removeThreads[i] = new Thread(new Remover(sharedData));
        //}

        // start and make main thread wait until all threads are done
        for (int i = 0; i < NUM_THREADS; i++) {
            addThreads[i].start();
            //removeThreads[i].start();
            addThreads[i].join();
            //removeThreads[i].join();
        }

        // we should expect the SharedData's size to be 0
        System.out.println(sharedData.size());
    }

}
