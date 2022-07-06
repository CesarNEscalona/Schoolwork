package facade.driver;

import facade.facade.EmployeeFacade;
import java.io.FileNotFoundException;

/**
 * This class consists of a main method that allows the program how to run
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class FacadeDriver {
    /**
     * @param args  the main method that has tests the facade
     * @throws FileNotFoundException if a file doesn't exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeFacade facade = new EmployeeFacade();
        // checks a first or last name to see if it matches a current employee
        try
        {
            System.out.println(facade.isANEmployee("Mika") + " <-- Should return True.");
            System.out.println(facade.isANEmployee("Cesar") + " <-- Should return False.");
            System.out.println(facade.isANEmployee("Madden") + " <-- Should return True.");
            System.out.println();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Employee name or last name not found.");
            System.exit(0);
        }
        // sorts employees by first name
        System.out.println("Sorting Employees by first name...");
        facade.sortByFirstName();
        System.out.println();

        // displays employees including first name, initial, and last name
        System.out.println("Displays all employees by full name");
        facade.employeeFirstAndLastName();
    }
}
