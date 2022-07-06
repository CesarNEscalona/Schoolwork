/**
 * This class implements Incrementable and initializes a value to be in the range of 1-100 and
 * it increases by a randomly generated number between 1-10 each time the method is called and saves
 * the final number.
 * Authors: Eashune Abenojar, Cesar Escalona
 * Edits made by Eashune Abenojar and Cesar Escalona 1/26
 */

import java.util.Random;

public class RandomIncrementer implements Incrementable {
    private int val;
    Random random = new Random();

    RandomIncrementer() {
        val = random.nextInt(100) + 1;
    }

    @Override
    public int increment() {
        val += random.nextInt(10) + 1;
        return val;
    }

    @Override
    public int getValue() {
        return val;
    }
}