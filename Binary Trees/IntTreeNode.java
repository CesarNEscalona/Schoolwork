/*
   Cesar Escalona
   it-220
   06/13/2020
*/

public class IntTreeNode {
   // fields
   public int data;
   public IntTreeNode left;      // address of the child node to my left
   public IntTreeNode right;     // address of the child node to my right
   
   // construct a leaf node tree with given data
   public IntTreeNode(int data) {
      this(data, null, null);
   }
   
   // helper constructors
   public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}