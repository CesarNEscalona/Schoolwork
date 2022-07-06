import org.junit.jupiter.api.RepeatedTest;
import random.PowerBall;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerBallTest {
    @RepeatedTest(10)
    public void testPowerBallNumbers() {
        // AAA = Arrange, Act, Assert
        // arrange, act
        PowerBall ball = new PowerBall();
        int[] numbers = ball.getNumbers();


        // assert (assume we have 6 numbers)
        for (int i = 0; i < numbers.length - 1; i++) // test the first 5 numbers
        {
            assertTrue(numbers[i] >= 1);
            assertTrue(numbers[i] <= 69);

        }
        // Test the last number
        assertTrue(numbers[numbers.length - 1] >= 1);
        assertTrue(numbers[numbers.length - 1] <= 69);
    }
}
