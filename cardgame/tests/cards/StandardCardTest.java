/**
 * Author: Cesar Escalona
 * SDEV 301 Systems Programming
 * This class will test the Constructor and toString methods
 * for the StandardCard Class
 */

package cards;

import org.junit.Test;
import static org.junit.Assert.*;

public class StandardCardTest {

    @Test
    public void testStandardCard() {
        // create a card obj
        Card card1 = new StandardCard("2","Hearts");
        // use assert to check if test failed or passed
        assertEquals("Test failed","2 of Hearts", card1.getCardText());
    }

    @Test
    public void testString() {
        // create a card obj
        Card card2 = new StandardCard("8", "Spades");
        // use assert to check if test failed or passed
        assertEquals("Test failed","8 of Spades", card2.toString());
    }
}