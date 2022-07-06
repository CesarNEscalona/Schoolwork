package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for movie names between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class FilmComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        // return the compare method for the strings
        return mine.getFilm().compareTo(other.getFilm());
    }
}
