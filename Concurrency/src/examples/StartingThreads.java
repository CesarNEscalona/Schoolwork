package examples;

public class StartingThreads {

    public static void main(String[] args) throws InterruptedException {

        // Create a MyThread object
        MyThread t = new MyThread();
        System.out.println(t.getName()+" is in state "+t.getState());
        // start up thread
        t.start();
        System.out.println(t.getName()+" is in state "+t.getState());

        // Create a Thread with MyRunnable and start it
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // Create a Runnable lambda expression(anonymous function)
        Runnable r = () -> {
            try {
                for (int i = 0; i < 30; i++) {
                    System.out.println("Hello, My name is Thread: " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is in state " + Thread.currentThread().getState());
                }
            }catch(InterruptedException e){
                System.out.println(Thread.currentThread().getName()+ "has been interrupted!!");
            }
        };
        Thread t3 = new Thread(r);
        t3.start();

        for (int i = 0; i < 30 ; i++) {
            System.out.println("Hello, My name is Thread: " +  Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+" is in state "+Thread.currentThread().getState());
        }



    }
}
