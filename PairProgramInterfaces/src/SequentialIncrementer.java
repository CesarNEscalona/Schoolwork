/**
 * This class will implement the Incrementable interface; This initializes the value at 0 and
 * increases by 1 each time its incremented
 * Authors: Eashune Abenojar, Cesar Escalona
 */

public class SequentialIncrementer implements Incrementable {
    private int val = 0;

    @Override
    public int increment() { return val++; }

    @Override
    public int getValue() {
        return val;
    }
}