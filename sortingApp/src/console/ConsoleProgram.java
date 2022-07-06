package console;

import movie.Movie;
import comparators.*;
import datalayer.DataLayer;
import heapsort.HeapSort;
import java.util.Random;

/**
 * This class handles all logic for the driver class. This class takes in user input and displays
 * things based on that.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class ConsoleProgram {

    /**
     * This method is called from the driver class once the game runs. This method does most of the work
     * in the program.
     */
    public void runProgram(){
        // create an array of movies and load our movies
        Movie[] test = DataLayer.load();
        // create a heapsort to sort the movies
        HeapSort sort = new HeapSort();
        // gets User's input choice
        int choice = welcomeAndInput();

        // Make a check for valid entries 1-4...
        choice = validateChoice(choice);

        // if user selects option 1
        if(choice == 1){
            printHeader();
            // print out each value in the movie array
            printMovieData(test);
        }

        // if user selects option 2
        if(choice == 2){
            // Print out the top row
            printHeader();
            // print out one random movie
            printRandomMovie(test);
        }

        // if user selects option 3
        if(choice == 3){
            // print out comparator menu and save user input
            int comparator = printComparatorMenu();
            // validate selection
            while(comparator < 1 || comparator > 8){
                System.out.println("Please enter a valid menu selection\n");
                comparator = printComparatorMenu();
                if(comparator >= 1 && comparator <= 8){
                    break;
                }
            }

            // case 1 - Film Comparator
            filmCase(test, sort, comparator);

            // case 2 - Genre Comparator
            genreCase(test, sort, comparator);

            // case 3 - Studio Comparator
            studioCase(test, sort, comparator);

            // case 4 - Audience Comparator
            audienceCase(test, sort, comparator);

            // case 5 - Profit Comparator
            profitCase(test, sort, comparator);

            // case 6 - Rotten Comparator
            rottenCase(test, sort, comparator);

            // case 7 - Gross Comparator
            grossCase(test, sort, comparator);

            // case 8 - Year Comparator
            yearCase(test, sort, comparator);
        }
    }

    // private helper methods
    private int validateChoice(int choice) {
        while(choice < 1 || choice > 4){
            System.out.println("Please enter a number between 1 and 4\n");
            // get users choice again
            choice = welcomeAndInput();
            // if choice is valid, break out
            if(choice > 1 && choice < 4){
                break;
            }
        }
        return choice;
    }

    private void yearCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 8){
            // use sort.sort to sort
            sort.sort(test, new YearComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void grossCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 7){
            // use sort.sort to sort
            sort.sort(test, new WorldGrossComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void rottenCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 6){
            // use sort.sort to sort
            sort.sort(test, new RTComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void profitCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 5){
            // use sort.sort to sort
            sort.sort(test, new ProfitComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void audienceCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 4){
            // use sort.sort to sort
            sort.sort(test, new AudienceComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void studioCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 3){
            // use sort.sort to sort
            sort.sort(test, new StudioComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void genreCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 2){
            // use sort.sort to sort
            sort.sort(test, new GenreComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private void filmCase(Movie[] test, HeapSort sort, int comparator) {
        if(comparator == 1){
            // use sort.sort to sort
            sort.sort(test, new FilmComparator());
            // empty line before header
            System.out.println();
            // Print header
            printHeader();
            // print out each value in the movie array after sort
            printMovieData(test);
        }
    }

    private int printComparatorMenu() {
        return Console.getInt("Enter a comparator: \n" +
                        "1. By film\n" +
                        "2. By genre\n" +
                        "3. By studio\n" +
                        "4. By audience\n" +
                        "5. By profit\n" +
                        "6. By RT score\n" +
                        "7. By world gross\n" +
                        "8. By year\n");
    }

    private void printRandomMovie(Movie[] test) {
        Random random = new Random();
        int number = random.nextInt(test.length);
        System.out.printf("%-35s", test[number].getFilm());
        System.out.printf("\t%-20s", test[number].getGenre());
        System.out.printf("\t%-20s", test[number].getStudio());
        System.out.printf("\t%-20s", test[number].getAudienceScore());
        System.out.printf("\t%-20.2f", test[number].getProfitability());
        System.out.printf("\t%-20s", test[number].getRottenScore());
        System.out.printf("\t%-20.2f", test[number].getWorldGross());
        System.out.printf("\t%-20s", test[number].getYear());
        System.out.println();
    }

    private void printMovieData(Movie[] test) {
        for (Movie movie : test) {
            // print our carefully aligned data
            System.out.printf("%-35s", movie.getFilm());
            System.out.printf("\t%-20s", movie.getGenre());
            System.out.printf("\t%-20s", movie.getStudio());
            System.out.printf("\t%-20s", movie.getAudienceScore());
            System.out.printf("\t%-20.2f", movie.getProfitability());
            System.out.printf("\t%-20s", movie.getRottenScore());
            double gross = movie.getWorldGross();
            System.out.printf("\t%-20.2f", gross);
            System.out.printf("\t%-20s", movie.getYear());
            System.out.println();
        }
    }

    private void printHeader() {
        // Print out the top row
        System.out.printf("%-35s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\t%-20s\n",
                "FILM", "GENRE", "STUDIO", "AUDIENCE SCORE %", "PROFIT",
                "ROTTEN TOMATOES %", "WORLDWIDE GROSS", "YEAR");
    }

    private int welcomeAndInput() {
        System.out.println("*******************************************\n" +
                "Welcome to the Movie Night Application\n" +
                "\n" +
                "This program will display movie suggestions\n" +
                "and allow you to sort movies in different\n" +
                "ways.\n" +
                "*******************************************\n");

        // get input from the user and save to variable
        int choice = Console.getInt("Pick from the following: \n" +
                "1. Show all movies \n" +
                "2. Show a random movie \n" +
                "3. Sort movies \n" +
                "4. Exit \n");
        System.out.println();
        return choice;
    }
}
