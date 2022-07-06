package movie;

/**
 * This class creates a movie object with various parameters
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class Movie implements Comparable<Movie>{

    // define movie variables
    private String film;
    private String genre;
    private String studio;
    private int audienceScore;
    private double profitability;
    private int rottenScore;
    private double worldGross;
    private int year;

    /**
     * @param film takes in a film that the movie corresponds to
     * @param genre takes in the genre of the movie passed in
     * @param studio takes in the studio for the film
     * @param audienceScore takes in a score that the audience rated
     * @param profitability takes in the profitability of the movie
     * @param rottenScore takes in the rotten tomato score from the movie
     * @param worldGross takes in the gross profit worldwide from the film
     * @param year takes in the year that the movie was released
     */
    public Movie(String film, String genre, String studio, String audienceScore,
                 String profitability, String rottenScore, String worldGross, String year){

        this.film = film;
        this.genre = genre;
        this.studio = studio;
        this.audienceScore = Integer.parseInt(audienceScore);
        this.profitability =  Double.parseDouble(profitability);
        this.rottenScore =  Integer.parseInt(rottenScore);
        this.worldGross = Double.parseDouble(worldGross);
        this.year = Integer.parseInt(year);
    }


    /**
     * @return returns the name of the movie
     */
    public String getFilm() {
        return film;
    }

    /**
     * @return returns the movie genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return returns the studio that made the movie
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @return returns the audience score for the movie
     */
    public int getAudienceScore() {
        return audienceScore;
    }

    /**
     * @return returns the profitability for the movie
     */
    public double getProfitability() {
        return profitability;
    }

    /**
     * @return returns the rotten tomato score for the movie
     */
    public int getRottenScore() {
        return rottenScore;
    }

    /**
     * @return returns the gross profit for the movie
     */
    public double getWorldGross() {
        return worldGross;
    }

    /**
     * @return returns the year that the movie released
     */
    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie other) {
        // compare Movies by film
        return film.compareTo(other.getFilm());
    }

    @Override
    public String toString() {

        return (film +", " + genre +", " + studio +", " + audienceScore +", " + profitability +", " +
                rottenScore +", " +
                worldGross +", " +
                year);
    }
}
