package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for year releases between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class YearComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        // give a comparison that equals
        if(mine.getYear() == other.getYear()){
            // use year by calling compareTo from Movie class
            return mine.compareTo(other);
        }
        // return either 1 or -1
        return mine.getYear() - other.getYear();
    }
}
