/*
   Cesar Escalona
   It-219
   This program will read in a file and take the numbers and display them
   as well as the sum of those numbers. 
   *** Extra challenge, Place the numbers into an Array of doubles
*/

import java.io.*;
import java.util.*;

public class AddEmUp
{
   public static void main(String[] args)
   {
      // read in the file
      File addObj = new File("nums.txt");
      // creating the array
      double[] dubsArray = new double[7];
      
      // Try catch for the doubles and sum of total
      try(Scanner file_in = new Scanner (addObj))
      {
         double number = 0;
         double total = 0;
         int index = 0;
         while(file_in.hasNextDouble())
         {
            number = file_in.nextDouble();
            System.out.println("Number = " + number);
            index++;
            total += number;
         }
         System.out.println("Sum = " + total);
      }
      catch(FileNotFoundException exception)
      {
         System.err.println(exception.toString());
      }
      
      // try catch for the Array
      try(Scanner file_in = new Scanner (addObj))
      {
         int index = 0;
         while(file_in.hasNextDouble())
         {
            dubsArray[index] = file_in.nextDouble();
            index++;
         }
      }
      catch(FileNotFoundException exception)
      {
         System.err.println(exception.toString());
      }
      // print out the array
      System.out.println(Arrays.toString(dubsArray));
      
   } // end of main method
} // end of class

/*   Output
       ----jGRASP exec: java AddEmUp
 Number = 308.2
 Number = 15.0
 Number = -47.5
 Number = 61.2
 Number = 9.0
 Number = 27.0
 Number = -3.0
 Sum = 369.9
 [308.2, 15.0, -47.5, 61.2, 9.0, 27.0, -3.0]
 
  ----jGRASP: operation complete.

*/