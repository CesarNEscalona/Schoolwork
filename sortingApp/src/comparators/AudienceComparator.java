package comparators;

import movie.Movie;
import java.util.Comparator;

/**
 * This class provides a comparison for audience score between two films
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class AudienceComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie mine, Movie other) {
        if(mine.getAudienceScore() == other.getAudienceScore()){
            // use the data
            return mine.compareTo(other);
        }
        return mine.getAudienceScore() - other.getAudienceScore();
    }
}
