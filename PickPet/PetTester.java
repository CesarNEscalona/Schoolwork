/* 
   Cesar Escalona and Adam Percival
   iT-219
   02/10/2020
   This program will take in user input(name, age, gender) and will output a pet based on gender and age

*/

import java.util.Scanner;

public class PetTester
{
   public static void main(String[] args)
   {
      // create a Scanner object to connect to keyboard
      Scanner kb = new Scanner(System.in);
     
      // Ask for user's name
      System.out.print("Enter your name: ");
      // read in name to a variable called name
      String name = kb.nextLine();
      
      // Ask for user's age
      System.out.print("Enter your age: ");
      // read in age to a variable called age
      int age = kb.nextInt();
      
      // Ask for user's Gender
      System.out.print("Enter your gender: ");
      // read in gender to a variable called gender
      String gender = kb.next();
      
      // construct a Person
      Person p1 = new Person(name, age, gender);
      System.out.println(p1.findPet());
   }
}