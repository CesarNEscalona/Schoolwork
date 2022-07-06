package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for film genres between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class GenreComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        return mine.getGenre().compareTo(other.getGenre());
    }
}
