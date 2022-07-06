package sharedcounter;

public class SharedData {

    private int count;

    public synchronized void increment() {
        // lock on the intrinsic Object - Synchronized
        count++;
        // unlock at the end of method
    }

    public int getCount() {
        return count;
    }
}
