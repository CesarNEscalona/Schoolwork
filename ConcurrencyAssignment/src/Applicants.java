/**
 *  Author: Cesar Escalona
 *  Date: 03/17/21
 *  Class: Sdev301 - Systems Programming
 *  This class will represent a producer Thread that implements the Runnable interface. This program will generate
 *  applications with random credit scores and credit limits. In addition, this class will produce applications for
 *  3 minutes. This class also flips a coin to see if the thread is delayed or not. If so, the time is randomly generated
 */

import java.util.*;

public class Applicants implements Runnable{
    // instance field
    private ApplicationQueue mySharedQueue;

    // default parameterized constructor
    public Applicants(ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    @Override
    public void run() {
            // generate time to be running
            long time = System.currentTimeMillis();
            long waitTime = 18000;  // 18k ms = run for approx 3 mins
            long endWaitTime = time + waitTime;

            // while loop around everything while true or while time
            System.out.println(java.lang.Thread.currentThread().getName() + " started!");
            while (System.currentTimeMillis() < endWaitTime) {
                // Create Random number Generator to create parameters needed for credit apps
                Random rand = new Random();
                // highest credit score should be 850
                int creditUpper = 850;
                // lowest credit score should be 300
                int creditLower = 300;
                // max credit limit request is 50,000
                int limitUpper = 50000;
                // least credit limit is 5k
                int limitLower = 5000;
                // construct credit request between 5k - 50k
                int requestedLimit = rand.nextInt(limitUpper - limitLower) + limitLower;

                // Create a producer Thread with random credit and request limit
                Application Producer = new Application(rand.nextInt(creditUpper - creditLower) + creditLower,
                        rand.nextInt(limitUpper - limitLower) + limitLower);
                // add it to the shared queue
                mySharedQueue.addApplication(Producer);
                // print out the output
                System.out.println(Thread.currentThread().getName() +": created application #" + Producer.getApplicationID());

                // flip a coin to delay the thread before creating another app
                int supper = 1200;  // max amount of ms to sleep
                int slower = 100;   // min amount of ms to sleep
                int coin = rand.nextInt(2);  // either 0 or 1
                if (coin == 0) {
                    // use try catch anytime thread sleeps
                    try {
                        // generate random time it sleeps between min and max time
                        Thread.sleep(rand.nextInt(supper - slower) + slower);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        // When out of the loop, print the current thread as finished
        System.out.println(Thread.currentThread().getName() +" finished");
    }
}
