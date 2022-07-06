/**
 * Assignment: Pair Program Lockers
 * Authors: Cesar Escalona, Jake Gerald
 * SDEv 301 Systems Programming
 * This program will feature a Lockers Problem where 50 students walk into a school. The first student opens all 50
 * lockers, the second student closes lockers that are multiples of two, the third student inverts all multiples of 3
 * and so on until we get to student 50
 */

package lockers;

import bitArray.BitArray;

public class Lockers {
    private static final int LOCKERS = 50;

    public static void main(String[] args) {
        BitArray lockers = new BitArray();

        // creates a loop that includes 50 students all opening/closing lockers
        for (int studentNum = 0; studentNum < LOCKERS; studentNum++) {
            for (int lockerNum = 0; lockerNum < LOCKERS; lockerNum++) {
                if((lockerNum + 1) % (studentNum + 1) == 0) {
                    lockers.set(lockerNum, !lockers.get(lockerNum));
                }
            }
        }

        // Check to see which are open and which are closed at the end
        for (int lockerNum = 0; lockerNum < LOCKERS; lockerNum++) {
            System.out.println((lockerNum + 1) + ": " + (lockers.get(lockerNum) ? "Open" : "Closed"));
        }
    }
}