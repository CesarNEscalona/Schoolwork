package datalayer;

import movie.Movie;
import java.io.*;
import java.util.*;

/**
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class DataLayer {

    public static final int SIZE = 71;

    /**
     * Default constructor
     *
     */
    public DataLayer(){
        // empty...
    }

    /**
     * @return Returns a movie array of movies from the file
     */
    public static Movie[] load(){
        // find the path
        String path = "file/movies.csv";
        // create an array of movies 71
        Movie[] movies = new Movie[SIZE];
        // read in the file
        try(Scanner reader = new Scanner(new File(path))){
            // create a flag variable to pass in an index
            int index = 0;
            // Skips the first line with only strings...
            reader.nextLine();
            // while file still has lines of text, go in
            while (reader.hasNextLine()){
                // create an array of strings to pass into a movie object
                String[] parts = reader.nextLine().split(",");
                // Create a movie obj based on info from the file
                Movie movie1 = new Movie(parts[0], parts[1], parts[2], parts[3],
                                        parts[4], parts[5], parts[6], parts[7]);
                // add the movie obj to an array or movies
                movies[index] = movie1;
                // point to the next index
                index++;
            }
        } catch (FileNotFoundException e) {
            // if file not found, throw exception
            System.out.println("File not found...Try again");
        }
        // return the movies array
        return movies;
    }
}