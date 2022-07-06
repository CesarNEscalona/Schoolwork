import java.util.*;

public class TreeTester {
   
   public static void main(String[] args) {
      IntTree tree = new IntTree();
      
      tree.printPreorder();
      System.out.println();
      
      tree.printInorder();
      System.out.println();
      
      tree.printPostorder();
      System.out.println();
      
      System.out.println("Sum of the tree is " + tree.sum());
      
      System.out.println(tree);
      
      // Chapter 11
      Set<String> names = new TreeSet<>();
      Map<String, Integer> ages = new TreeMap<>();  // python dictionary
   }
}