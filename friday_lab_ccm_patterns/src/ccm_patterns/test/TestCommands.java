package ccm_patterns.test;

import ccm_patterns.commands.ICommand;
import ccm_patterns.concrete_commands.CapitalizeCommand;
import ccm_patterns.concrete_commands.CompositeCommand;
import ccm_patterns.concrete_commands.RandomizeCommand;
import ccm_patterns.concrete_commands.ReplaceVowelsCommand;
import ccm_patterns.entities.StringStorage;

/**
 * This class will take in a string storage object and change it based on the commands given, it will
 * then revert the string back to what it originated using the Memento Pattern.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class TestCommands
{
    /**
     * @param args the main method that will run the program
     */
    public static void main(String[] args)
    {
        // create a string storage object
        StringStorage stringify = new StringStorage("Hello World! My name is Cesar.");
        // take a snapshot of the original stringify by creating a memento
        StringStorage.Memento memento = stringify.createMemento();

        // make a few commands
        ICommand capitalizeCommand = new CapitalizeCommand(stringify);
        ICommand randomizeCommand = new RandomizeCommand(stringify);
        ICommand replaceCommand = new ReplaceVowelsCommand(stringify);

        // place commands in a command array
        ICommand[] arr = new ICommand[]{
                capitalizeCommand, randomizeCommand, replaceCommand};

        // check original stringify before any changes
        System.out.println("Original --> " + stringify);

        /* Uncomment to test the commands executing individually in the loop
        for (int i = 0; i < arr.length; i++) {
            arr[i].execute();
            System.out.println(arr[i].toString());
        }
        */
        //test the composite command class
        CompositeCommand test = new CompositeCommand(arr);
        test.execute();

        // check the state of the stringify after the modifications
        System.out.println("After mods --> " + stringify);

        // Call memento to revert any changes made to stringify
        stringify.setMemento(memento);

        // check the state of stringify
        System.out.println("after Memento --> " + stringify);
    }
}
