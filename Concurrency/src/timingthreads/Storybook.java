/**
 *  Author: Cesar Escalona
 *  3/9/2021
 *  Sdev 301 Systems Programming
 *  This class will create a timed storybook tale using Threads. After the first output, it waits 2 seconds, then
 *  prints out the second output and prints out 10 "." on the same line. After that it should print out an
 *  empty new line.
 */


package timingthreads;

public class Storybook implements Runnable{

    @Override
    public void run() {
        System.out.println("Welcome to my storybook!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("The story began long, long ago");
        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }
}