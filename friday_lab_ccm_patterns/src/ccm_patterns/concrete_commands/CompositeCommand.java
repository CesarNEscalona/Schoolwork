package ccm_patterns.concrete_commands;

import ccm_patterns.commands.ICommand;
import java.util.Arrays;

// this command is a group of commands
public class CompositeCommand implements ICommand{

    private ICommand[] commands;

    public CompositeCommand(ICommand[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (ICommand comma:
             commands) {
            comma.execute();
            System.out.println(comma);
        }
    }

    @Override
    public String toString() {
        return "CompositeCommand = " + Arrays.toString(commands);
    }
}
