/**
   Cesar Escalona
   IT-219
   02/02/2020
   This program will output an Employee
*/


// this class represents an employee
public class Employee 
{
    private double salary;
    private String lastName;
    private String firstName;
    private String socialNum;

    // parameterized constructor
    public Employee(String lastName, String firstName, String socialNum, double salary)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.socialNum = socialNum;
        this.salary = salary;
    } // end of constructor
    
    // override the Object's toString() Method
    public String toString()
    {
        return "Employee [ "+firstName+" "+lastName+" social: "+ socialNum + " salary: " + salary +" ]";
    } // end of ToString
    
    // tester
    public static void main(String[] args)
    {
       Employee emp01 = new Employee("Tranh", "Hla", "456-89-0123", 123450.50);
       System.out.println(emp01.toString());
    } // end of main 
} // end of class

/*
 Expected output
 Employee [ Hla Tranh social: 456-89-0123 salary: 123450.50 ]
 
 
 
 Actual Output
     ----jGRASP exec: java Employee
 Employee [ Hla Tranh social: 456-89-0123 salary: 123450.5 ]
 
  ----jGRASP: operation complete.
 
*/