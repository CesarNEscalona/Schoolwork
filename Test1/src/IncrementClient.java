/**
 * this class prints and test the other classes
 * by creating an object and calling it.
 */

public class IncrementClient {
    public static void main(String[] args) {
        SequentialIncrementer increment = new SequentialIncrementer();
        RandomIncrementer randomInc = new RandomIncrementer();


        for (int i = 0; i < 4; i++) {
            increment.increment();
            randomInc.increment();
        }
        System.out.println("Sequential Value: " + increment.getValue());
        System.out.println();
        System.out.println("Random Value: " + randomInc.getValue());
    }
}
