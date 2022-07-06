package examples;

// older way to create a Thread extends Thread
public class MyThread extends Thread{

    // put work for the thread in a run method
    @Override
    public void run() {
        // add a try catch to handle the Interrupted Exception
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello, My name is Thread: " + this.getName());
                Thread.sleep(1000); // have to handle the checked exception Interrupted Exception
                System.out.println(this.getName() + " is in state " + this.getState());
            }
        }catch(InterruptedException e){
            System.out.println(this.getName()+ "has been interrupted!!");
        }
    }

}
