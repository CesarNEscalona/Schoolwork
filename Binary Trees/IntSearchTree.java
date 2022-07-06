/*
   Cesar Escalona
   it-220
   06/13/2020
*/

public class IntSearchTree {

   // field(s)
   private IntTreeNode overallRoot;   // default is null
   
   // methods
   public IntSearchTree() {
      // default was null but writing to be sure
      overallRoot = null;
   }
   // public helper method
   public void add(int value) {
      overallRoot = add(overallRoot, value);
   }
   
   private IntTreeNode add(IntTreeNode root, int value) {
      if (root == null) {
         root = new IntTreeNode(value);
      }
      else if (value <= root.data) {
         root.left = add(root.left, value);
      }
      else {
         root.right = add(root.right, value);
      }
      return root;
   }
   
   // public helper method
   public boolean contains(int value) {
      return contains(overallRoot, value);
   }
   
   // private recursive method - this one does all the work
   private boolean contains(IntTreeNode root, int value) {
      if (root == null) {
         return false;
      }
      else if(value == root.data) {
         return true;
      }
      else if(value < root.data) {
         return contains(root.left, value);
      }
      else { // value > root.data)
         return contains(root.right, value);
      }
   }
   
   //public helper method
   public void printInorder() {
      System.out.println("inorder:");
      printInorder(overallRoot);
      System.out.println();
   }
   
   // private recursive method that does the work
   private void printInorder(IntTreeNode root) {
      if(root != null) {
         printInorder(root.left);
         System.out.print(" "+ root.data);
         printInorder(root.right);
      }
   }
      
   // printSideways method
   public void printSideways() {
      printSideways(overallRoot, 0);
   }
   
   private void printSideways(IntTreeNode root, int level) {
      if(root != null) {
         printSideways(root.right, level + 1);
         
         for(int i = 0; i < level; i++) {
            System.out.print("   ");
         }
         System.out.println(root.data);
         printSideways(root.left, level + 1);
      }
   }
}