/**
 * Author: Cesar Escalona
 * 02/20/2021
 * Sdev 301 Systems Programming
 * This program will allow two users to play a simple numbers game very similar to tic tac toe. It features
 * a collection of MagicSquares that can be represented by numbers.
 */

package squares;

import java.util.*;

public class MagicSquareGame {

    // Main method
    public static void main(String[] args) {
        byte[] square = new byte[]{2, 7, 6, 9, 5, 1, 4, 3, 8};
        // Calling the method for the Title of the game
        System.out.println(PrintInstructions());
        // Creating MagicSquare objects for player 1, 2, and 3 which holds both squares
        MagicSquare P1 = new MagicSquare(square);
        MagicSquare P2 = new MagicSquare(square);
        MagicSquare P3 = new MagicSquare(square);
        // Get the scanner in the console
        Scanner Players = new Scanner(System.in);

        // Enter username and press Enter
        System.out.println("Enter a name for player #1");
        String name1 = Players.nextLine();

        // Enter username and press Enter
        System.out.println("Enter a name for player #2");
        String name2 = Players.nextLine();

        // create a variable to keep track of the number of moves
        int start = 1;
        // create a variable to keep the game going
        boolean winner = false;
        // loop through the program to check for numbers until there is a clear winner or tie
        while (!winner &&
                start < 10) {
            // Player 1 goes on odd turns and Player 2 goes on even turns
            if(start % 2 == 1) {
                System.out.println(name1 + ", please enter a number: ");
                byte p1s1 = Players.nextByte();

                // Use a try catch to avoid program
                // from stopping after the exception
                try{
                    P1.choose(p1s1);
                }
                // let the user select a different number within the range
                catch(IllegalArgumentException e) {
                    while (p1s1 < 1 || p1s1 > 9){
                        System.out.println(p1s1 + " is not between 1 and 9");
                        p1s1 = Players.nextByte();
                    }
                }
                // check if number is not available and give player another change to pick
                while (P3.hasAlreadyChosen(p1s1)) {
                    System.out.println("A player has already chosen " + p1s1);
                    p1s1 = Players.nextByte();
                }
                P3.choose(p1s1);
                // Enter toString here
                System.out.println(P1.toString());
                // Check if P1 wins, display the message if true
                winner = winningCondition(P1.getChoices());
                if(winner) {
                    System.out.println("Player 1 wins");
                }
            }
            // Player 2
            else {
                System.out.println(name2 + ", please enter a number: ");
                byte p2s1 = Players.nextByte();

                // Use a try catch to avoid program
                // from stopping after the exception
                try{
                    P2.choose(p2s1);
                }
                // let the user select a different number within the range
                catch(IllegalArgumentException e) {
                    while (p2s1 < 1 || p2s1 > 9){
                        System.out.println(p2s1 + " is not between 1 and 9");
                        p2s1 = Players.nextByte();
                    }
                }
                // If number is not available, display it
                while (P3.hasAlreadyChosen(p2s1)) {
                    System.out.println("A player has already chosen " + p2s1);
                    p2s1 = Players.nextByte();
                }
                P3.choose(p2s1);
                // Enter toString here
                System.out.println(P2.toString());
                // Check if P2 wins, display the message if true
                winner = winningCondition(P2.getChoices());
                if(winner) {
                    System.out.println("Player 2 wins");
                }
            }
            // Increase the number of plays
            start++;
        }
        // If we get to this point and number of tries == 10, the game is a draw
        if(start == 10){
            System.out.println("The game is a draw!");
        }
    }

    // This method will create the Title of the game
    public static String PrintInstructions() {
        return "Welcome to the game of Magic Squares \n" +
                "************************************ \n" +
                "Rules: \n" +
                "2 players play the game\n" +
                "Each player takes turns picking a number from 1-9 \n" +
                "No number can be chosen twice \n" +
                "The first player to have 3 numbers that sum to 15 wins! \n" +
                "2 7 6 \n" +
                "9 5 1 \n" +
                "4 3 8 \n" +
                "************************************ \n";
    }

    // This method will keep an array of the winning conditions, so when a Player gets this, they win
    public static boolean winningCondition(short choices) {
        short[] win = new short[] {(short)0b0_0110_0010, (short)0b1_0001_0001,
                (short) 0b0_1000_1100, (short) 0b0_1010_0001, (short)0b0_0101_0100, (short) 0b1_0000_1010,
                (short) 0b0_1001_0010, (short) 0b0_0011_1000};
        // if the player choice equals one of these numbers in the array, the winning condition is true
        for (int i = 0; i < win.length; i++) {
            if(choices == win[i]) {
                return true;
            }
        }
        return false;
    }
}