/*
   Cesar Escalona
   IT-219
   This program will create an array of 50 total numbers and will generate random 
   numbers from 0 to 10 for the 50 buckets using a random number generator.
   Then this program will find the sum of all the array numbers and 
   will count how many 6's and 8's are in the array and return the amounts. 
   Lastly, this program will take the decimal numbers inside an array and will
   return the smallest number from the array.
*/
import java.util.*;

public class RandomInts
{ 
   public static void main(String[] args)
   {
      findMin();
      
      int sum = 0;
      int count = 0;
      Random ran = new Random();
      int [] rands = new int[50];
      for(int i = 0; i < rands.length; i++)
      {
         rands[i] = ran.nextInt(11);
         System.out.print(rands[i] + " ");
         
         sum = sum + rands[i];
         
         if(rands[i] == 6 || rands[i] == 8)
         {
            count++;
         }
      }
      System.out.println("\nTotal sum of numbers = " + sum);
      System.out.println("Total count of numbers 6 and 8 = " + count);
   } // end of main method
   
   public static int findMin()
   {
      Random dub = new Random();
      double [] d = { 1.5, 2.3, 3.5, 1.4, 1.1};
      int i = 0;
      System.out.println(Arrays.toString(d));
      
      for(i = 0; i < d.length; i++)
      {
         double min = d[0];
         
         for( i=1; i< d.length; i++)
         {
            if(d[i] < min)
            {
               min = d[i];
            }
         }
         System.out.println("Minimum double in the array = " + min);
      }
      return i;
   }
}