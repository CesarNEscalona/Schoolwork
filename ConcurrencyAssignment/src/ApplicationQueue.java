/**
 *  Author: Cesar Escalona
 *  Date: 03/17/21
 *  Class: Sdev301 - Systems Programming
 *  This class will represents a shared queue used by Applicants and Credit Company threads.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ApplicationQueue {
    // instance field
    public static final int MAX = 100;
    // instance field - Thread safe
    private static BlockingQueue<Application> apps = new ArrayBlockingQueue<>(MAX);
    // Method that adds the application object to the apps queue - Thread safe
    public void addApplication(Application app) {
        try {
            apps.put(app);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Method that removes the application object from the apps queue - Thread safe
    public Application removeApplication() {
        try {
            Application app = apps.take();
            return app;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
