package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for the rotten tomatoes score between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class RTComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        if(mine.getRottenScore() == other.getRottenScore()) {
            return mine.compareTo(other);
        }
        return mine.getRottenScore() - other.getRottenScore();
    }
}
