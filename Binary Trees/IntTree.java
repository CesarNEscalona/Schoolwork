/*
   Cesar Escalona
   it-220
   06/13/2020
*/

public class IntTree {
   
   // fields
   private IntTreeNode overallRoot;
   
   // reference p. 1042
   public IntTree(int max) {
      if(max < 0) {
         throw new IllegalArgumentException("max: " + max);
      }
      overallRoot = buildTree(1, max);
   }
   
   // reference p. 1043
   private IntTreeNode buildTree(int n, int max) {
      if(n > max) {
         return null;
      }
      else {
         // intTreeNode left = buildTree(2 * n, max);
         // intTreeNode right = buildTree(2 * n + 1, max);
         // return new IntTreeNode(n, left, right);
         return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
      }
   }
   
   // p 1036 M-L-R
   public void printPreorder() {
      System.out.println("preorder:");
      printPreorder(overallRoot);
      System.out.println();
   }
   
   // p 1036 Preorder means M-L-R, Print Me, then Left, then Right
   private void printPreorder(IntTreeNode root) {
      if(root != null) {
         System.out.print(" " + root.data);
         printPreorder(root.left);
         printPreorder(root.right);
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
   
   // Postorder means - L-R-M
   public void printPostorder() {
      System.out.println("postorder:");
      printPostorder(overallRoot);
      System.out.println();
   }
   
   // p 1036 Postorder means L-R-M, Print Left, then Right, then Me
   private void printPostorder(IntTreeNode root) {
      if(root != null) {
         printPostorder(root.left);
         printPostorder(root.right);
         System.out.print(" " + root.data);
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
   
   // Sum method p. 1049
   public int sum() {
      return sum(overallRoot);
   }
   
   private int sum(IntTreeNode root) {
      if(root == null) {
         return 0;
      }
      else {
         return root.data + sum(root.left) + sum(root.right);
      }
   }
   
   // Count levels method p. 1050
   public int countLevels() {
      return countLevels(overallRoot);
   }
   
   private int countLevels(IntTreeNode root) {
      if(root == null) {
         return 0;
      }
      else {
         return 1 +
         Math.max(countLevels(root.left),
         countLevels(root.right));
      }
   }
   
   // Counting leaves p. 1052
   public int countLeaves() {
      return countLeaves(overallRoot);
   }
   
   private int countLeaves(IntTreeNode root) {
      if(root == null) {
         return 0;
      }
      else if (root.left == null && root.right == null) {
         return 1;
      }
      else {
         return countLeaves(root.left) + countLeaves(root.right);
      }
   }
   
} // end of class