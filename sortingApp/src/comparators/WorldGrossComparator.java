package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for worldwide gross profit between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class WorldGrossComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        // if mine<other return -1
        //if mine>other return 1
        // if equal return 0
        return Double.compare(mine.getWorldGross(), other.getWorldGross());
    }
}
