import java.util.*;
public class ArrayBasics
{
    public static void main(String[] args)
    {
       createArray();
       
       
       // declare an integer array to hold 30 grades
       int[] grades = new int[30];
       // use enhanced for each loop to print out the grades
       for(int n : grades)
       {
          System.out.print(n + " ");
       }
       System.out.println();
       // use traditional for loop to assign 60 to each
       // element
       for(int i = 0; i < grades.length; i++)
       {
          grades[i] = 60;
       }
       System.out.println(Arrays.toString(grades));
       
       // change array from 60 to "Hi"
       String[] greetings = new String[40];
       Arrays.fill(greetings, "Hi");
       System.out.println(Arrays.toString(greetings));
       
       
    }
       // good way to create an array
       public static int[] createArray()
       {
          int[] vals = { 5, 2, 4, 3, 7 };
          // System.out.println("created " + Arrays.toString(arr));
          for(int i = 0; i < vals.length; i++)
          {
             if(i % 2 ==1)
             {
                vals[i]++;
             }
          }
          
          System.out.println("created " + Arrays.toString(vals));
          return vals;
       }
}