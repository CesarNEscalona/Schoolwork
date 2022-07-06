import java.util.*; // toString equals, copyOf, sort

public class ArraysClassMethods
{
   public static void main(String[] args)
   {
      // declare/initialize an array of Strings to hold 3 names
      String[] names = { "Bob", "Tom", "Jerry" };
      String[] names2 = { "Laverne", "Shirley", "Lucy" };
      
      // Does names1 contain the same elements in the same order
      // as names2 
      // static methods don't require you to create an object 
      // (using new) to call them and usually you pass the 
      // information you are working with
      boolean answer = Arrays.equals(names, names2);
      System.out.println("Arrays equal? " + answer);
      
      // copy names into names5
      String[] names5 = Arrays.copyOf(names, 3);
      
      // sort method will sort my names array alphabetically
      // permanently
      Arrays.sort(names);
      System.out.println(Arrays.toString(names));
      System.out.println(Arrays.toString(names5));
      
      // demo using the split() method which operates
      // on a single string and returns an array of strings split
      // apart by the string tokem
      String data = "Mary,Smith,23,Seattle,WA";
      String[] pieces = data.split(",");
      System.out.println("First name: " + pieces[0]);
      System.out.println("Last name: " + pieces[1]);
      System.out.println("Age: " + pieces[2]);
      System.out.println("City: " + pieces[3]);
      System.out.println("State: " + pieces[4]);
   }
}