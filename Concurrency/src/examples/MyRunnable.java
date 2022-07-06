package examples;

public class MyRunnable implements Runnable{

    @Override
    public void run(){
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello, My name is Thread: " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " is in state " + Thread.currentThread().getState());
            }
        }catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName()+ "has been interrupted!!");
        }
    }
}