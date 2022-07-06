package facade.facade;

import facade.employees.Employee;
import facade.utilities.FileUtilities;
import facade.utilities.RecordsUtilities;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class will feature a few methods that will make it easier to work with the modules.
 * *** JUSTIFICATION: THIS CLASS WILL MAKE IT EASIER FOR USERS TO WORK WITH THE MODULES BECAUSE INSTEAD OF GOING TO
 * EACH CLASS AND USING METHODS ON EACH, THE USER COULD JUST USE MY METHODS TO FIND WHAT THEY NEED. NORMALLY A USER
 * WOULD HAVE TO ACCESS THE TEXT FILE FIRST, THEN IMPORT IT TO PRINT OUT SOME RECORDS ***
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class EmployeeFacade {

    /**
     * This method takes in a name and checks if an employee exists with either a first name or last name
     *
     * @param name takes in a name passed in from a user
     * @return returns a boolean based on the name passed in
     * @throws FileNotFoundException throws an exception if a file is not found
     */
    // returns a boolean based on the name passed in from a user
    public boolean isANEmployee(String name) throws FileNotFoundException {
        boolean match = false;
        RecordsUtilities utilities = new RecordsUtilities();
        FileUtilities reader = new FileUtilities();
        Scanner scanner = reader.getFileReader("files/records.csv");
        List<Employee> employees = new ArrayList<>();

        // fills list of employees
        while(scanner.hasNext()){
            employees.add(utilities.deserialize(scanner.next()));
        }
        // looking at everyone
        for (Employee names: employees) {
            if (name.equals(names.getFirstName()) || name.equals(names.getLastName())) {
                match = true;
                break;
            }
        }
        return match;
    }

    /**
     * This method will sort the list of employees by first name
     *
     * @throws FileNotFoundException if a file is not found
     */
    public void sortByFirstName() throws FileNotFoundException {
        RecordsUtilities records = new RecordsUtilities();
        FileUtilities files = new FileUtilities();
        Scanner scanner = files.getFileReader("files/records.csv");
        List<Employee> employees = new ArrayList<>();
        List<String> total = new ArrayList<>();

        while (scanner.hasNext()){
            employees.add(records.deserialize(scanner.next()));
        }
        for (Employee employee:
             employees) {
            records.serialize(employee);
            total.add(employee.getFirstName());;
        }
        Collections.sort(total);
        for (String fName:
             total) {
            System.out.println(fName);
        }
    }

    /**
     * This method will display employees by first name, middle initial, and last name
     *
     * @throws FileNotFoundException throws an exception if a file is not found
     */
    // Prints out full name from the file
    public void employeeFirstAndLastName() throws FileNotFoundException {
        List<Employee> employees = new ArrayList<>();
        RecordsUtilities records = new RecordsUtilities();
        FileUtilities files = new FileUtilities();
        Scanner scanner = files.getFileReader("files/records.csv");
        while (scanner.hasNext()){
            employees.add(records.deserialize(scanner.next()));
        }
        for (Employee emp:
             employees) {
            System.out.println(emp.getFirstName()
                    + " "+
                    emp.getMiddleInit() + ". "
                    + emp.getLastName());
        }
    }
}
