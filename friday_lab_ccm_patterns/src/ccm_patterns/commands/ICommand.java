package ccm_patterns.commands;

/**
 * This interface will consist of one method that will be used in concrete command classes
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public interface ICommand
{
    /**
     * This is the method all concrete classes will consist of
     */
    void execute();
}
