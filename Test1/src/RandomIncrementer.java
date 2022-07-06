import java.util.Random;

/**
 * this class chooses a random number which then
 * increases value field randomly when calling increment method
 * and returns value when getValue method gets called
 */
public class RandomIncrementer implements Incrementable {
    Random random = new Random();
    int value = random.nextInt(101) + 1;
    @Override
    public int increment() {
        value += random.nextInt(11) + 1;
        return value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
