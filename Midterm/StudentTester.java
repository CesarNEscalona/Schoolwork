/*
   Cesar Escalona
   02/13/2020
   This system will ask for user input and output correctly


*/

import java.util.Scanner;  // Scanner class

public class StudentTester
{

   public static void main(String[] args)
   {
      // create a Scanner object to connect to keyboard
      Scanner kb = new Scanner(System.in);
     
      System.out.print("Enter your Student ID: ");
      // read in id
      int id = kb.nextInt();
      
      // force the user to enter an id in the range 8000 to 9000
      // using a while loop
      while( id < 8000 || id > 9000)
      {
         System.out.print("Enter a differemt Student ID: ");
         id = kb.nextInt();
      }  // end of while
      
      
      // fix/remove the new line in buffer
      kb.nextLine();
      
      System.out.print("Enter your course Name: ");
      // read in course
      String courseName = kb.nextLine();
      
      
      // force them to enter IT 219
      while(!courseName.equals("It 219"))  // you could write this as (!"It 219".equals(courseName))
      {
         courseName = kb.nextLine(); 
      }
     
      System.out.print("Enter your course Grade: ");
      // read in grade 
      double courseGrade = kb.nextDouble();
      
      // construct a Student
      Student student1 = new Student(id, courseName, courseGrade);
      System.out.println(student1);
   }
}

/*
   Output:
          
  ----jGRASP exec: java StudentTester
 Enter your Student ID: 840421964
 Enter your course Name: It 219
 Enter your course Grade: 88
 
 Id: 840421964
 Course: It 219
 Grade: 88.0
 
  ----jGRASP: operation complete.
 
 
*/