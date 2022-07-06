/*
   Cesar Escalona
   it-220
   06/13/2020
*/

import java.util.*;

public class IntTreeClient {
   
   public static void main(String[] args) {
      // System.out.println("test");
      
      // p. 1046
      IntTree t = new IntTree(12);
      System.out.println("Tree structure:");
      t.printSideways();
      System.out.println();
      t.printPreorder();
      t.printInorder();
      t.printPostorder();
      System.out.println("The sum is " + t.sum());
      System.out.println("There are " + t.countLevels() + " levels to this tree");
      System.out.println("There are " + t.countLeaves() + " Leaves on this tree");
   }
}