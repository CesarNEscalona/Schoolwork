import math.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {
    @Test
    public void testExceptionsWithDivide() {

        MyMath math = new MyMath();

        assertAll(
                () -> assertThrows(ArithmeticException.class, () -> math.divide(10, 0)),
                () -> assertDoesNotThrow( () -> math.divide(10, 3)),
                () -> assertDoesNotThrow( () -> math.divide(10, -3))
        );
    }
}
