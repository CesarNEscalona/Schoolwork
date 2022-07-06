package ccm_patterns.concrete_commands;

import ccm_patterns.commands.ICommand;
import ccm_patterns.entities.StringStorage;

/**
 * This class will take in a string from a user and will replace all vowels in the string with an asterisk
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class ReplaceVowelsCommand implements ICommand {

    private StringStorage source;

    /**
     * @param source the source string passed in from a user
     */
    public ReplaceVowelsCommand(StringStorage source) {
        this.source = source;
    }

    @Override
    public void execute() {
        char[] vows = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        String data = source.getData();
        for (char vow : vows) {
            data = data.replace(vow, '*');
        }
        source.setData(data);
    }

    @Override
    public String toString() {
        return "ReplaceVowelsCommand = "+ source;
    }
}
