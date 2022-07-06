package driver;

import console.ConsoleProgram;

/**
 * This is the driver class that handles the entire program
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class Driver {

    /**
     * The main method will load my program into the console
     *
     * @param args the main method contains the runProgram method that will contain all the code
     *             needed to run this program
     */
    public static void main(String[] args) {
        ConsoleProgram run = new ConsoleProgram();
        run.runProgram();
    }
}