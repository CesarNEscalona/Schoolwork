package builder;

import java.time.LocalDate;

/**
 * This class consists of the main method that will run the program
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class StoryDriver {
    /**
     * @param args the main method that constructs a story using story builder
     */
    public static void main(String[] args) {

        Story myStory = new StoryBuilder()
                .setAuthor("J.K. Rowling")
                .setTitle("Harry Potter And The Null Pointer Exception")
                .setReleasedOn(LocalDate.now())
                .addStoryLine("Harry ran into a problem.")
                .addStoryLine("The Null Pointer had grown bigger and stronger.")
                .addStoryLine("The Dark Lord feared this Null Pointer.")
                .build();
        System.out.println(myStory.toString());

        Story blank = new StoryBuilder()
                .blank();
        System.out.println(blank);
        System.out.println();

        String story = new StoryBuilder()
                .setAuthor("J.K. Rowling")
                .setTitle("Harry Potter And The Null Pointer Exception")
                .setReleasedOn(LocalDate.now())
                .addStoryLine("Harry ran into a problem.")
                .addStoryLine("The Null Pointer had grown bigger and stronger.")
                .addStoryLine("The Dark Lord feared this Null Pointer.")
                .toString();
        System.out.println(story);
    }
}
