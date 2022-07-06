/*
   Cesar Escalona
   IT-219
   02/19/2020
   This program will genetate ramdom numbers bewteen 5-10 and stop once it reaches number 8,
   this program will add numbers 1 to 70 inclusive,
   this program will ask the user to guess a fruit and once the user guesses "apple" the system
   will print the amount of incorrect guesses.
*/

import java.util.Scanner;
import java.util.*;
import javax.swing.*;

public class Loops
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      
      // call generateNums since its static you could 
      // prefix it with the class name
      Loops.generateNums(5,10,8);
      
      // call addNumbers since it is non-static you
      // need an object to call it
      Loops test = new Loops();
      test.addNumbers();
      int total = test.addNumbers4();
      
      // call guessFruit
      // Loops.guessFruit();
      int incorrect = guessFruit();
      JOptionPane.showMessageDialog(null, "It took " +
      incorrect + " guesses");
   }
   
   // this method adds up 1-70 and returns the sum
   public static int addNumbers4()
   {
      final int MIN = 1;  // declaring constants
      final int MAX = 70;
      
      int total = 0;
      for(int count = MIN; count <= MAX; count++)
         total += count;
         return total;
    }
    
   public void addNumbers()
   {
      final int MIN = 1;  // declaring constants
      final int MAX = 70;
      int count = MIN;
      int total = 0;
      
      // sum up the numbers 1 though 70
      // using a while loop and print out the sum
      while (count <= MAX)
      {
         total += count;
         count++;
      }
      System.out.println("\nTotal is " +total);
   }
   
   // This method randomly generates and prints integers in the range min-max
   // inclusive until the stopping number is hit
   public static void generateNums(int min, int max, int stop)
   {
      // create a random generator
      Random gen = new Random();
      
      // error check that stop is between min and max
        if(stop < min || stop > max)
      {
         System.out.println(stop + " is not in range");
         return;
      }
      
      int num = max+1;
      // while (keep generating numbers until stop is generated)
      while (num != stop)
      {
         // int num = gen.nextInt(10)  //0,1,2,3...9
         // generate 5 to 10
         num = gen.nextInt(max - min + 1) + min;
         System.out.print(num + " ");
      }
      System.out.println("Outside Loop");
   }
   
   // This method prompts the user for fruit names until they guess apple
   // amd will return the number of incorrect guesses 
   public static int guessFruit()
   {
      int counter = 0;
      String fruit = "";
      
      while (!fruit.equalsIgnoreCase("apple"))
      {
         fruit = JOptionPane.showInputDialog(null,"Enter a fruit: ");
         counter = counter + 1;
      }
      return --counter;
   }
}