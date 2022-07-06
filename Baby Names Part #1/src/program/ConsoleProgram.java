package program;

import baby_names.BabyNames;
import baby_names.FileIO;
import bst.BabyNamesTree;
import java.util.Collections;
import java.util.List;

/**
 * This class contains a console program that allows users to search through Baby Names data.
 * The user will be prompted to choose a state and year and the program will out put data based on that. The
 * user will also have the ability to pick one of four options based on what they want to do.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class ConsoleProgram {

    /**
     * Loads my program
     * @param args The main method contains the runProgram() method that will contain
     *             all of the code needed to run this program.
     */
    public static void main(String[] args) {
        runProgram();
    }

    /**
     * This method will initialize the program by outputting data
     */
    public static void startProgram() {
        System.out.println("Welcome to my Baby Names program");
        System.out.println("********************************");
        System.out.println("This program shows the top baby names for each state.");
        System.out.println("Names are organized by year, state, gender and frequency");
        System.out.println("********************************");
        System.out.println(" ");
    }

    /**
     * This method will contain the majority of the program. It should feature a loop, a list, a tree
     * and all of the required options.
     */
    public static void runProgram() {
        // Create a flag variable for the while loop
        int flag = 0;
        // Call the method to display the starting data
        startProgram();

        // Save the users inputs into variables
        String state = program.Console.getString("Enter the name of a state (press enter)");
        int year = program.Console.getInt("Enter a year (1910-2019): ");

        // Create a tree of BabyNames
        BabyNamesTree tree2 = new BabyNamesTree();
        // Create a list of BabyNames from the FileIO
        List<BabyNames> list = FileIO.read(state, year);
        // Shuffle the list for randomness
        Collections.shuffle(list);

        // Loop through each item and add to the tree
        for (int i = 0; i < list.size(); i++) {
            tree2.add(list.get(i));
        }
        // Output the height of the tree
        System.out.println("Searching for a name will take no more than " + tree2.treeHeight() + " comparisons.");
        System.out.println(" ");

        // While loop for the program to keep running
        while (flag == 0) {
            int choice = program.Console.getInt("Enter a choice: \n" +
                    "1: Show names \n" +
                    "2: Search for name \n" +
                    "3: Change State \n" +
                    "4: Exit \n");
            System.out.println(" ");

            // If user chooses option 1
            if (choice == 1) {
                // iterate through and print out the names
                for (BabyNames names : tree2) {
                    System.out.println(names);
                }
                System.out.println(" ");
            }

            // If option 2 is chosen
            else if (choice == 2) {
                // Save the user input into a variable
                String option2 = program.Console.getString("Enter a name");
                // Create a BabyNames element containing the data from the tree
                BabyNames found = tree2.get(option2);
                // If the name matches...
                if (found != null) {
                    System.out.println("Name found!");
                    System.out.println(found);
                    // Create a variable consisting of the found name's depth
                    int nameComparison = tree2.nodeDepth(found);
                    System.out.println("Your search took " + nameComparison + " comparisons to find.\n");
                } else { // if the name is not found
                    System.out.println("Name not found");
                }
            }

            // If option 3 is chosen
            else if (choice == 3) {
                // overwrite the variables to the new state and year
                state = program.Console.getString("Enter the name of a state (press enter)");
                year = program.Console.getInt("Enter a year (1910-2019): ");
                tree2 = new BabyNamesTree();
                list = FileIO.read(state, year);
                // re-shuffle the list
                Collections.shuffle(list);

                // add the elements of the list into the tree randomized
                for (int i = 0; i < list.size(); i++) {
                    tree2.add(list.get(i));
                }
                // Output the height of the tree
                System.out.println("Searching for a name will take no more than "
                        + tree2.treeHeight() + " comparisons.");
                System.out.println(" ");
            }

            // If option 4 is chosen
            else if (choice == 4) {
                // Increment flag variable to end the program
                flag++;
            }
        }
    }
}
