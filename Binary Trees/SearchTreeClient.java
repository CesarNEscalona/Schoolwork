/*
   Cesar Escalona
   it-220
   06/13/2020
*/

import java.util.*;

public class SearchTreeClient {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      SearchTree<String> names = new SearchTree<>();
      System.out.print("Name (blank to quit)? ");
      
      String name = console.nextLine();
      while(name.length() > 0) {
         names.add(name);
         System.out.print("Name (blank to quit)? ");
         name = console.nextLine();
      }
      System.out.println();
      System.out.println("Alphabetized list:");
      names.printInorder();
      System.out.println();
      
      SearchTree<Integer> numbers = new SearchTree<>();
      System.out.print("Next int (0 to quit)? ");
      int number = console.nextInt();
      while(number != 0) {
         numbers.add(number);
         System.out.print("Next int (0 to quit)? ");
         number = console.nextInt();
      }
      System.out.println();
      System.out.println("Sorted list:");
      numbers.printInorder();
   }
}