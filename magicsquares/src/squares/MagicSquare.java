/**
 * Author: Cesar Escalona
 * 02/20/2021
 * Sdev 301 Systems Programming
 * This program will focus on manipulating integer numbers in Java at the binary level. This program features how
 * bit masking works and how to apply bitwise operators. This application will allow two users to
 * play a simple numbers game.
 */

package squares;

import java.util.ArrayList;

public class MagicSquare {

    // Instance fields
    private short choices;
    private byte[] square;

    // Default parameterized constructor
    public MagicSquare(byte[] square) {
        this.square = square;
    }

    // This method checks the number chosen by the player, if its out of bounds, throw exception
    public boolean choose(byte selection) throws IllegalArgumentException {
        if (selection < 1 || selection > 9) {
            throw new IllegalArgumentException("Please choose a number between 1-9");
        }
        // various selections picked by the user, and what short it represents
        if (selection == 1) {
            choices = (short) (choices | 0b0_0000_0001);
        }
        if (selection == 2) {
            choices = (short) (choices | 0b0_0000_0010);
        }
        if (selection == 3) {
            choices = (short) (choices | 0b0_0000_0100);
        }
        if (selection == 4) {
            choices = (short) (choices | 0b0_0000_1000);
        }
        if (selection == 5) {
            choices = (short) (choices | 0b0_0001_0000);
        }
        if (selection == 6) {
            choices = (short) (choices | 0b0_0010_0000);
        }
        if (selection == 7) {
            choices = (short) (choices | 0b0_0100_0000);
        }
        if (selection == 8) {
            choices = (short) (choices | 0b0_1000_0000);
        }
        if (selection == 9) {
            choices = (short) (choices | 0b1_0000_0000);
        }

        // System.out.println(Integer.toBinaryString(choices));
        //if else statement here
        if(hasAlreadyChosen(selection)) {
            // If selection has been chosen, return false
            return false;
        } else {
            return true;
        }
    }

    // Checks to see if number has already been chosen
    // uses a mask and & to return a boolean value based on the number passed in
    public boolean hasAlreadyChosen(byte selection) {
        // create a mask
        short mask = (short) (0b0000_0000_0000_0001 << selection - 1);
        //return true if the bit is set to the on position, false otherwise
        short result = (short) (choices & mask);
        return result == mask;
    }

    // Getter
    public short getChoices() {
        return choices;
    }

    // Getter
    public byte[] getSquare() {
        return square;
    }

    // This method will generate a toString that checks for numbers called and displays them
    public String toString() {
        // build an empty string
        String build = "";
        // create an array list to keep track of numbers chosen
        ArrayList<Integer> test = new ArrayList<>();

        // create a for loop to check if the numbers have been chosen
        for (int i = 0; i < 9; i++) {
            short mask = (short) (0b0000_0000_0000_0001 << i);
            //return true if the bit is set to the on position, false otherwise
            short result = (short) (choices & mask);
            if(result == mask) {
                test.add(i+1);
            }
        }
        // create a for loop to check for numbers chosen compared to arraylist numbers
        for (int i = 0; i < square.length; i++) {
            // create a false variable to determine if the numbers have been chosen
            boolean loop = false;
            // iterate through the arraylist loop
            for (int j = 0; j < test.size(); j++) {
                // number at square index == number at j index
                if(square[i] == test.get(j)){
                    // add the number at i and a space
                    build += square[i] + " ";
                    // if loop is true then display that number in the string
                    loop = true;
                }
            }
            // if number doesn't match picked number, add a _ and a space
            if(!loop){
                build += "_ ";
            }
            // for selection 2 and 5 enter a line separator
            if(i == 2 || i == 5){
                build += System.lineSeparator();
            }
        }
        // return String
        return build;
    }
}