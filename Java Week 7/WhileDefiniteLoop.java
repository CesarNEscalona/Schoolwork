public class WhileDefiniteLoop
{

   public static void main(String[] args)
   {
      // use while loop to sum up the numbers 1 to 5
      // outside loop print the sum
      // 1 + 2 + 3 + 4 + 5 = 15
      // use counter variable to represent 1,2,3,4,5
      // use accumulator variable to hold the running sum
      // define variables for counter and accumulator
      // and initialize
      int count = 1;
      int total = 0;
      
      while (total < 15)
      {
         // add count to total
         total += count;  // this means total = total + count
         count++;
         System.out.println(count + "  " + total);
      }
      
      System.out.println("Total is " + total);
   }
   
}