/**
 * this class increases value field by 1 when calling increment method
 * and returns value when getValue method gets called
 */
public class SequentialIncrementer implements Incrementable {
    private int value = 0;

    @Override
    public int increment() {
        return value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
