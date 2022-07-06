package threadsafety;

import java.time.*;

public class Adder implements Runnable {
    private SharedData data;

    public Adder(SharedData data){
        this.data = data;
    }
    public void run(){
        for (int i = 1; i <= 1000 ; i++) {
            data.add("thread-safety");
        }
    }
}
