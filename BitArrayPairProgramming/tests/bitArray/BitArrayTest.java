/**
 * Assignment: Pair Program Bit Array Test
 * Authors: Cesar Escalona, Jake Gerald
 * SDEv 301 Systems Programming
 * This program will test the Bit array class set and get methods
 */

package bitArray;

import org.junit.Test;
import static org.junit.Assert.*;

public class BitArrayTest {
    @Test
    public void testSetMethod(){
        BitArray bits = new BitArray();

        // set all bits to true
        for (int i = 0; i < 64; i++) {
            bits.set(i,true);
        }

        // verify all bits are true
        for (int i = 0; i < 64; i++) {
            assertEquals("get("+i+") incorrectly returned false",true, bits.get(i));
            // could use assertTrue
        }

        // set all bits to false
        for (int i = 0; i < 64; i++) {
            bits.set(i,false);
        }

        // verify all bits are false
        for (int i = 0; i < 64; i++) {
            assertEquals("get("+i+") incorrectly returned true",false, bits.get(i));
            // could use AssertFalse
        }
    }

}