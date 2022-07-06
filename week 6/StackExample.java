
import java.util.*;

public class StackExample {

   public static void main(String[] args) {
      System.out.println("Welcome to StackExample!");

      Stack<String> s = new Stack<String>();
      
      s.push("this");
      s.push("is");
      s.push("sparta");
      s.push("i'll");
      s.push("be");
      s.push("back");
      
      System.out.println("s is " + s);  // for debugging
      
      String theTop = s.peek();
      System.out.println(theTop);
      s.pop();    // remove "back"
      s.pop();    // remove "be"
      s.pop();    // remove "i'll"
      
      System.out.println(s.peek());
      
      System.out.println("------");
      while (!s.isEmpty()) {
         System.out.println(s.pop());
      }
      
      System.out.println("s is " + s);  // for debugging

      // s.pop();
      
      
   }

}