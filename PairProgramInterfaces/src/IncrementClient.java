/**
 * This class will test other classes by calling the increment and random value 4 times.
 * Authors: Eashune Abenojar, Cesar Escalona
 */

public class IncrementClient {
    public static void main(String[] args) {

        SequentialIncrementer incrementer = new SequentialIncrementer();
        RandomIncrementer random = new RandomIncrementer();

        for(int i = 0; i < 4; i++) {
            incrementer.increment();
            random.increment();
        }

        System.out.println("Sequential Value: " + incrementer.getValue());
        System.out.println("");
        System.out.println("Random Value: " + random.getValue());
    }
}