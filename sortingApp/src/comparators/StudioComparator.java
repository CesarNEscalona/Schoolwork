package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison of studios between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class StudioComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        return mine.getStudio().compareTo(other.getStudio());
    }
}
