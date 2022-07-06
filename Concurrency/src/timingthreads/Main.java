/**
 *  Author: Cesar Escalona
 *  3/9/2021
 *  Sdev 301 - Systems Programming
 *  Thread Timing
 *  This program will start the Storybook thread and then call the Thread.join() to wait until the
 *  run task has completed. Should output something on the main thread adter we call .join()
 */


package timingthreads;

public class Main extends Thread{

    public static void main(String[] args) {
        Storybook t = new Storybook();
        t.run();

        Thread p = new Thread();
        try {
            p.join();
        } catch (InterruptedException e) {
            // do nothing
        }
        System.out.println("And they lived happily ever after!");
    }
}