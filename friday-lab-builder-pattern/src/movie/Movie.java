package movie;

public class Movie {

    private String title;
    private String genre;
    private int yearReleased;
    private int lengthInMinutes;
    private double starsRating;
    private boolean canStreamIt;

    public Movie() {
        // do nothing
    }

    public Movie(String title, String genre, int yearReleased, int lengthInMinutes,
                 double starsRating, boolean canStreamIt) {
        this.title = title;
        this.genre = genre;
        this.yearReleased = yearReleased;
        this.lengthInMinutes = lengthInMinutes;
        this.starsRating = starsRating;
        this.canStreamIt = canStreamIt;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public double getStarsRating() {
        return starsRating;
    }

    public boolean isCanStreamIt() {
        return canStreamIt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setStarsRating(double starsRating) {
        this.starsRating = starsRating;
    }

    public void setCanStreamIt(boolean canStreamIt) {
        this.canStreamIt = canStreamIt;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearReleased=" + yearReleased +
                ", lengthInMinutes=" + lengthInMinutes +
                ", starsRating=" + starsRating +
                ", canStreamIt=" + canStreamIt +
                '}';
    }
}
