/**
 *  Author: Cesar Escalona
 *  Sdev 301 Systems - Programming
 *  3/4/2021
 *  This program will feature a main method that will start my thread. This program should print the string values in
 *  my StringHolder and RunnableStringHolder class
 */

package startingthreads;

public class Driver {
    // create a main method
    public static void main(String[] args) {

        // Create a StringHolder object
        StringHolder t = new StringHolder("");
        // start the thread
        t.start();

        // Create a Thread with MyRunnable and start it
        Thread t2 = new Thread(new RunnableStringHolder(""));
        //start the thread
        t2.start();
    }
}