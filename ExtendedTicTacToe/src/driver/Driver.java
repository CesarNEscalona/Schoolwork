package driver;

import match.Match;

/**
 * This is the driver class that handles the entire game
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class Driver {

    /**
     * The main method will load my program into the console
     *
     * @param args the main method contains the RunProgram() method that will contain
     *             all the code needed to run this program
     */
    public static void main(String[] args) {
        runProgram();
    }

    /**
     * This helper method will start the game and ask for user input to ask if they want to play
     * an Ai match or a user match. Then it will create the board for option 1 and 2, otherwise it will
     * terminate the game with option 3
     */
    public static void runProgram() {
        // keep the game running
        while (true) {
            // start the game
            System.out.println();
            System.out.println("Welcome to extended Tic Tac Toe \n" +
                    "1. Play a randomized match\n" +
                    "2. Play a user-controlled match\n" +
                    "3. Exit Program");
            // store the selection
            int selection = console.Console.getInt();
            // check for in bounds selection
            if (selection > 3 || selection < 1) {
                System.out.println("Please enter an eligible number.\n");
            }
            // computer random match
            else if (selection == 1) {
                Match myMatch = new Match(true);
                myMatch.playGame();
            }
            // user controlled match
            else if (selection == 2) {
                Match myMatch = new Match(false);
                myMatch.playGame();
            }
            // exit program
            else {
                break;
            }
        }
    }
}
