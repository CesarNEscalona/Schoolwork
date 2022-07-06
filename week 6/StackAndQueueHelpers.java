import java.util.*;

public class StackAndQueueHelpers {

   public static void main(String[] args) {
   
      // make a new queue of strings, call the variable q
      Queue<String> q = new LinkedList<>();
      
      // add in some items into the queue
      q.add("for");
      q.add("instance");
      q.add("on");
      q.add("planet");
      q.add("earth");
      
      Stack<String> s = new Stack<>();
      // s is empty
      
      System.out.println("q before: " + q);
      System.out.println("s before: " + s);
      queueToStack(q, s);
      System.out.println("q after: " + q);
      System.out.println("s after: " + s);
      
      //while (!s.isEmpty()) {
      //   System.out.println(s.pop());
      //}
      
      stackToQueue(s, q);
      System.out.println("q final: " + q);
      System.out.println("s final: " + s);

   }
   
   // helper method that transfers items from a queue into a stack
   public static void queueToStack(Queue<String> q, Stack<String> s) {
      while (!q.isEmpty()) {
         String word = q.remove();
         s.push(word);
      }
   }
   
   // helper method that transfers items from a stack into a queue
   public static void stackToQueue(Stack<String> s, Queue<String> q) {
      while (!s.isEmpty()) {
         String word = s.pop();
         q.add(word);
      }
   }
   
}