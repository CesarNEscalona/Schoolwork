/**
 * Author: Cesar Escalona
 * SDEV 301 Systems Programming
 * This class will test the Constructor and toString methods
 * for the Card Class
 */

package cards;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testCard() {
        // create an obj to test
        Card card1 = new Card("test");
        // Use assert to check if test failed or passed
        assertEquals("Test failed", "test",card1.getCardText());
    }
    @Test
    public void testString() {
        // create an obj to test
        Card card2 = new Card("test 2");
        // use assert to check if test failed or passed
        assertEquals("Test Failed","test 2", card2.toString());
    }
}