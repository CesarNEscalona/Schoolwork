package builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class uses a builder pattern to construct a story
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class StoryBuilder {
    private String author;
    private String title;
    private LocalDate releasedOn;
    private List<String> storyLines;

    /**
     * Default constructor, returns nothing...
     */
    public StoryBuilder() {
        // returns nothing...
    }

    /**
     * Sets the author of a story
     *
     * @param author sets what is passed in as the author
     * @return returns an instance of StoryBuilder
     */
    public StoryBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     * Sets the title of a story
     *
     * @param title sets what is passed in as the title
     * @return returns an instance of StoryBuilder
     */
    public StoryBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the local date of when a story released
     *
     * @param releasedOn sets what is passed in as the local date time
     * @return returns an instance of StoryBuilder
     */
    public StoryBuilder setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
        return this;
    }

    /**
     * Special Setter - adds a single line (string) to the list of lines
     *
     * @param line sets what is passed in as a story line
     * @return returns an instance of StoryBuilder
     */
    public StoryBuilder addStoryLine(String line) {
        if (storyLines == null){
            storyLines = new ArrayList<>();
        }
        storyLines.add(line);
        return this;
    }

    /**
     * Assembles a story object from fields in the builder
     *
     * @return returns a new story build
     */
    public Story build(){
        return new Story(author, title, releasedOn, storyLines);
    }

    /**
     * Creates a blank story obj with sensible defaults
     *
     * @return returns a default blank story
     */
    public Story blank(){
        return new Story("Unspecified", "Unspecified", LocalDate.now(), new ArrayList<>());
    }

    // Creates a string representation of the data in the builder suitable for printing
    @Override
    public String toString(){
        String first =  new StringBuilder()
                .append("Author: ")
                .append(author)
                .append("\n")
                .append("Title: ")
                .append(title)
                .append("\n")
                .append("Released: ")
                .append(releasedOn)
                .append("\n")
                .append("******************************************************")
                .toString();
        System.out.println(first);

        // have to split up string builder to iterate through list of strings
        // edge case, no lines = NullPointerException
        if(storyLines == null){
            System.out.println("No Content");
        }
        else {
            for (String line:
                    storyLines) {
                System.out.println(line);;
            }
        }

        String second = new StringBuilder()
                .append("******************************************************")
                .toString();
        System.out.println(second);
        return "";
    }
}
