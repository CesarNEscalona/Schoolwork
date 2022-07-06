import java.util.*;

public class Test {
   
   public static void main(String[] args)
   {
      System.out.println("***");
      
      // construct a list
      ArrayList<Integer> list = new ArrayList<>();
      
      // add 2, 3, 5, 4, 7, 15, 20, 7
      list.add(2);
      list.add(3);
      list.add(5);
      list.add(7);
      list.add(15);
      list.add(20);
      list.add(7);
      // find the sum of the numbers in the arrayList
      int sum = 0;
      for (int n: list) {
         sum += n;
      }
      
      System.out.println(list);
      // Organize the list by sorting from small to large
      Collections.sort(list);
      System.out.println(list);
      // this is the sum
      System.out.println(sum);
     
   }
}