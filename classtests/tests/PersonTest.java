import names.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testConstructor() {
        Person me = new Person("Cesar", "Escalona");

        // verify that all fields assigned as expected
        assertAll(
                () -> assertEquals("Cesar", me.getFirst()),
                () -> assertEquals("Escalona", me.getLast()),
                () -> assertNull(me.getTitle()),
                () -> assertSame('\u0000', me.getMiddle())
        );
    }
}
