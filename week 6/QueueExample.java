import java.util.*;

public class QueueExample {

   public static void main(String[] args) {
      System.out.println("Welcome to StackExample!");

      Queue<String> q = new LinkedList<String>();
      
      q.add("this");
      q.add("is");
      q.add("sparta");
      q.add("i'll");
      q.add("be");
      q.add("back");
      
      System.out.println("q is " + q);  // for debugging
      
      String theFront = q.peek();
      System.out.println(theFront);
      q.remove();    // remove "this"
      q.remove();    // remove "is"
      q.remove();    // remove "sparta"
      
      System.out.println(q.peek());
      
      System.out.println("------");
      while (!q.isEmpty()) {
         System.out.println(q.remove());
      }
      
      System.out.println("q is " + q);  // for debugging

      // q.remove();
      
      
   }

}