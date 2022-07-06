package ccm_patterns.concrete_commands;

import ccm_patterns.commands.ICommand;
import ccm_patterns.entities.StringStorage;
import java.util.Random;

/**
 * This class will take in a string from a user and will randomize all letters in the string
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class RandomizeCommand implements ICommand {

    private StringStorage source;

    /**
     * @param source the source string passed in from a user
     */
    public RandomizeCommand(StringStorage source){
        this.source = source;
    }

    @Override
    public void execute() {
        Random ran = new Random();
        char[] characters = source.getData().toCharArray();

        for (int i = 0; i < characters.length; i++) {
            int other = ran.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[other];
            characters[other] = temp;
        }
        source.setData(new String(characters));
    }

    @Override
    public String toString() {
        return "RandomizeCommand = \"" + source + "\"";
    }
}
