package client;

import business.*;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeClientProgram {

    public static void main(String[] args) {
        // Store sally and bob in array of Employees called business
        Employee[] business = new Employee[5];
        // Store sally and bob in ArrayList of Employees call busn
        ArrayList<Employee> busn = new ArrayList<>();

        Employee sally = new Employee("Sally","Employee");
        System.out.println("Sally works " + sally.getHours() + " hours a week.");
        // TODO: Place sally in the business
        business[0] = sally;
        busn.add(sally);

        AdministrativeAssistant bob = new AdministrativeAssistant("Bob","Admin");
        System.out.println("Bob works " + bob.getHours() + " hours a week.");
        // TODO: Place bob in the business
        business[1] = bob;
        busn.add(bob);

        // TODO: for each loop through the business array and print hours a week worked
        for(Employee e : business){
            if ( e != null)
                System.out.println(e.getFullName() +" works " + e.getHours() + " hours a week.");
        }

        // before sort
        System.out.println("Before Sort: "+busn);

        // permanently changes the order of the list
        Collections.sort(busn);

        // after sort
        System.out.println("After Sort: "+busn);

    }


}
