/**
 *  Author: Cesar Escalona
 *  Date: 03/17/21
 *  Class: Sdev301 - Systems Programming
 *  This class will represent the driver program. It should pass producer and consumer threads as a parameter to
 *  the constructor methods, it should also create 3 producer threads and 2 consumer threads.
 */

public class TestCreditApplication {

    public static void main(String[] args) {
        ApplicationQueue queue = new ApplicationQueue();

        Thread P1 = new Thread(new Applicants(queue));
        P1.start();
        P1.setName("P1");

        Thread P2 = new Thread(new Applicants(queue));
        P2.start();
        P2.setName("P2");

        Thread P3 = new Thread(new Applicants(queue));
        P3.start();
        P3.setName("P3");

        Thread C1 = new Thread(new CreditCompany(queue));
        C1.start();
        C1.setName("C1");

        Thread C2 = new Thread(new CreditCompany(queue));
        C2.start();
        C2.setName("C2");
    }
}
