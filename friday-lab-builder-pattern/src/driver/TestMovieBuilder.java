package driver;

import movie.Movie;
import movie.MovieBuilder;
import note.Note;
import note.NoteBuilder;
import java.time.LocalDate;

public class TestMovieBuilder {
    public static void main(String[] args) {

        Movie myMovie = new MovieBuilder()
                .setTitle("Interstellar")
                .setGenre("Action")
                .setYearReleased(2017)
                .setLengthInMinutes(150)
                .setStarsRating(5.0)
                .setCanStreamIt(true)
                .assemble();
        System.out.println(myMovie);

        Note myNote = new NoteBuilder()
                .setTitle("Here's my Note")
                .setBodyText("This is the body")
                .setCreated(LocalDate.now())
                .setUpdated(LocalDate.now())
                .createNote();

        System.out.println(myNote);

    }
}
