/**
 * Assignment: Pair Program Bit Array
 * Authors: Cesar Escalona, Jake Gerald
 * SDEv 301 Systems Programming
 * This class will have get and set methods that will be used to flip a given position open/close
 */

package bitArray;

public class BitArray {
    private long data;

    public boolean get(int index) {
        // create a mask
        long mask = 1L << index;
        //return true or false based on result
        long result = data & mask;
        return result == mask;
    }

    public void set(int index, boolean value) {
        // create a mask
        long mask = 1L << index;

        if(value){
           // set it in the data
            data = data | mask;
            }
        else {
            data = data & ~mask;
            }
    }
}