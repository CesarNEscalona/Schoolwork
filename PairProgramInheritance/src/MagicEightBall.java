import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MagicEightBall extends Ball {
    private String[] messages;

    public MagicEightBall (Color color, String[] messages) {
        super(color);
        this.messages = messages;
    }

    public int getTotalMessages() {
        return messages.length;
    }

    public String getMessage(int index) {
        return messages[index];
    }

    public String shake() {
        System.out.println("You shake the magic eight ball.");
        Random random = new Random();
        int number = random.nextInt(getTotalMessages());

        return "The ball says: " + getMessage(number);
    }

    @Override
    public String toString() {
        return "MagicEightBall{" +
                "messages=" + Arrays.toString(messages) +
                "Color= " + super.toString() +
                '}';
    }
}
