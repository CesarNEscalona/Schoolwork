package movie;

public class MovieBuilder {

    private String title;
    private String genre;
    private int yearReleased;
    private int lengthInMinutes;
    private double starsRating;
    private boolean canStreamIt;

    public MovieBuilder() {
        // do nothing
    }

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieBuilder setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
        return this;
    }

    public MovieBuilder setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
        return this;
    }

    public MovieBuilder setStarsRating(double starsRating) {
        this.starsRating = starsRating;
        return this;
    }

    public MovieBuilder setCanStreamIt(boolean canStreamIt) {
        this.canStreamIt = canStreamIt;
        return this;
    }

    public Movie assemble(){
        return new Movie(title, genre, yearReleased, lengthInMinutes, starsRating, canStreamIt);
    }
}
