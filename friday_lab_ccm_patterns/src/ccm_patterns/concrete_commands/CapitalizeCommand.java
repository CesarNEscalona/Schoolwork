package ccm_patterns.concrete_commands;

import ccm_patterns.commands.ICommand;
import ccm_patterns.entities.StringStorage;

/**
 * This class will take in a string from a user and will capitalize all letters in the string
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class CapitalizeCommand implements ICommand{

    private StringStorage source;

    /**
     * @param source The source string passed in from a user
     */
    public CapitalizeCommand(StringStorage source) {
        this.source = source;
    }

    @Override
    public void execute() {
        String data = source.getData();
        data = data.toUpperCase();
        source.setData(data);
    }

    @Override
    public String toString() {
        return "CapitalizeCommand = " + source;
    }
}
