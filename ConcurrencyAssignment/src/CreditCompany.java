/**
 *  Author: Cesar Escalona
 *  Date: 03/17/21
 *  Class: Sdev301 - Systems Programming
 *  This class will represent a consumer Thread that implements the Runnable interface. This program will pull
 *  applications from the shared queue and process them. If the credit score isn't high enough, the applicant won't
 *  be eligible for a credit limit. Credit limit is based on credit score. Output should display correctly
 */

public class CreditCompany implements Runnable{
    // instance field
    private ApplicationQueue mySharedQueue;

    // default parameterized constructor
    public CreditCompany(ApplicationQueue mySharedQueue){
        this.mySharedQueue = mySharedQueue;
    }

    @Override
    public void run() {

        // remove/take applications from shared Application ArrayBlockingQueue to process them
        while(true) {
            Application Consumer = mySharedQueue.removeApplication();
            // if credit less than 580, not approved
            if(Consumer.getCreditScore() < 580){
                Consumer.setApproved(false);
                Consumer.setApprovedLimit(0);
            }

            // if credit greater than 580 but less than 670, approved but credit limit 5k
            if(Consumer.getCreditScore() > 580 && Consumer.getCreditScore() < 670){
                Consumer.setApproved(true);
                Consumer.setApprovedLimit(5000);
            }

            // if credit greater than 670 but less than 740, approved but credit limit 10k
            if(Consumer.getCreditScore() > 670 && Consumer.getCreditScore() < 740){
                Consumer.setApproved(true);
                Consumer.setApprovedLimit(10000);
            }

            // if credit greater than 740 but less than 800, approved but credit limit 25k
            if(Consumer.getCreditScore() > 740 && Consumer.getCreditScore() < 800){
                Consumer.setApproved(true);
                Consumer.setApprovedLimit(25000);
            }

            // if credit greater than 800, approved, credit limit 50k
            if(Consumer.getCreditScore() > 800){
                Consumer.setApproved(true);
                Consumer.setApprovedLimit(50000);
            }

            // How Applications should print out
            if (Consumer.getCreditScore() < 580) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + Consumer.getApplicationID()
                        + " with credit score " + Consumer.getCreditScore()
                        + " is not approved");
            }
            // How Applications should print out
            if (Consumer.getCreditScore() > 580 && Consumer.getCreditScore() < 670) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + Consumer.getApplicationID()
                        + " with credit score " + Consumer.getCreditScore()
                        + " is approved for $" + Consumer.getApprovedLimit() + " (requested: $"+
                        Consumer.getRequestedLimit() +")");
            }
            // How Applications should print out
            if (Consumer.getCreditScore() > 670 && Consumer.getCreditScore() < 740) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + Consumer.getApplicationID()
                        + " with credit score " + Consumer.getCreditScore()
                        + " is approved for $" + Consumer.getApprovedLimit() + " (requested: $"+
                        Consumer.getRequestedLimit() +")");
            }
            // How Applications should print out
            if (Consumer.getCreditScore() > 740 && Consumer.getCreditScore() < 800) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + Consumer.getApplicationID()
                        + " with credit score " + Consumer.getCreditScore()
                        + " is approved for $" + Consumer.getApprovedLimit() + " (requested: $"+
                        Consumer.getRequestedLimit() +")");
            }
            // How Applications should print out
            if (Consumer.getCreditScore() > 800) {
                System.out.println(Thread.currentThread().getName() + ": Application #" + Consumer.getApplicationID()
                        + " with credit score " + Consumer.getCreditScore()
                        + " is approved for $" + Consumer.getApprovedLimit() + " (requested: $"+
                        Consumer.getRequestedLimit() +")");
            }
        }
    }
}
