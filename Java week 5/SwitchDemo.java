/*
   This program will demo using the Scanner class and a switch
   statement with Strings and the .equals() which has to be used
   to check if Strings contain the same content value.
*/

import java.util.Scanner;

public class SwitchDemo
{
   public static void main(String[] args)
   {
      // create a Scanner object to connect to keyboard
      Scanner kb = new Scanner(System.in);
      
      // Ask for user's name
      System.out.print("Enter your name: ");
      // read in name to a variable called name
      String name = kb.nextLine();
      
      // If the user entered Russell, print out welcome VIP
      if (name.equalsIgnoreCase("Russell"))
      {
         System.out.println("Welcome, VIP");
      }
      else
      {
         System.out.println("Welcome");
      }
      
      // Ask for user's fav color
      System.out.print("Enter your favorite color: ");
      // read in color to a variable called fav
      String color = kb.nextLine();
      
      // use a switch to display messages based on color
      switch (color.toLowerCase())
      {
         case "red":
         case "yellow":
         case "blue":
            System.out.println("You picked a primary color");
            break;
            
         case "green":
         case "orange":
         case "purple":
            System.out.println("You picked a secondary color");
            break;
            
         default:
            System.out.println("That is a nice color!");
            break;
      } // end of switch
      
      System.out.println("All done");
   }
}