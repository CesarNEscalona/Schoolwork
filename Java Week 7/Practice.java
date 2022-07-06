/*
   Cesar Escalona
   It-219
   Unit 6 Learning Practice Loops
   This program will ask for a user input and then calculate the count and sum of those numbers using a while loop
   This program will use a for loop to create the numbers from this assignment

*/
import java.util.Scanner;

public class Practice
{
   public static void main(String[] args)
   {
    Practice.While();
    Practice.For();
    
   }
   public static void While()
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter a positive integer: ");
      int n = kb.nextInt();
      kb.nextLine();
      int count = 1;
      int sum = 1;
      
      while (count < 10)
      {
         // n += n;
         System.out.print("Enter a positive integer: ");
         n = kb.nextInt();
         count++;
         sum += n;
      }
      System.out.print("Count is "+ count);
      System.out.println("\nTotal is " + (sum));
   }
   
   public static void For()
   {
      for (int i=1; i<=1; i++)
      {
         for (int j = 4; j <=  10; j++)
         {
            System.out.print(j + " ");
         }
         System.out.println();
         
         for (int k = 6; k >= 1; k--)
         {
            System.out.print(k + " ");
         }
         System.out.println();
         
         for (int m = 1; m <= 8; m++)
         {
            System.out.print((m + m) + " ");
         }
         System.out.println();
         
         for (int n = 19; n >= 5; n--)
         {
            System.out.print((n--) + " ");
         }
         System.out.println();
         
         for (int p = 1; p <= 5; p++)
         {
            System.out.print(((p*8)-1) + " ");
         }
         System.out.println();
         
         for (int q = 2; q <= 64; q*=2)
         {
            System.out.print(q + " ");
         }
         System.out.println();
      }
   }
}
/*
   Output:
   
        ----jGRASP exec: java Practice
 Enter a positive integer: 1
 Enter a positive integer: 2
 Enter a positive integer: 3
 Enter a positive integer: 4
 Enter a positive integer: 5
 Enter a positive integer: 6
 Enter a positive integer: 7
 Enter a positive integer: 8
 Enter a positive integer: 9
 Enter a positive integer: 10
 Count is 10
 Total is 55
 4 5 6 7 8 9 10 
 6 5 4 3 2 1 
 2 4 6 8 10 12 14 16 
 19 17 15 13 11 9 7 5 
 7 15 23 31 39 
 2 4 8 16 32 64 
 
  ----jGRASP: operation complete.
 
*/