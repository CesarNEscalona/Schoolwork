public class IntTree {
   
   // fields
   private IntTreeNode root;   // default is null if not initialized
   
   //methods
   public IntTree() {
      // initialize root with a pre-canned tree (p. 1031)
      root = new IntTreeNode(12, null, null);
      root.left = new IntTreeNode(18);
      root.right = new IntTreeNode(7);
      root.left.left = new IntTreeNode(23);
      root.right.left = new IntTreeNode(4);
      root.right.right = new IntTreeNode(13);
   }
   
   //public helper method
   public void printPreorder() {
      printPreorder(this.root);
   }
   
   // private recursive method that does the work
   private void printPreorder(IntTreeNode theRoot) {
      if(theRoot != null) {
         System.out.print(" "+ theRoot.data);
         printPreorder(theRoot.left);
         printPreorder(theRoot.right);
      }
   }
   
   //public helper method
   public void printInorder() {
      printInorder(this.root);
   }
   
   // private recursive method that does the work
   private void printInorder(IntTreeNode theRoot) {
      if(theRoot != null) {
         printInorder(theRoot.left);
         System.out.print(" "+ theRoot.data);
         printInorder(theRoot.right);
      }
   }
   
   //public helper method
   public void printPostorder() {
      printPreorder(this.root);
   }
   
   // private recursive method that does the work
   private void printPostorder(IntTreeNode theRoot) {
      if(theRoot != null) {
         printPostorder(theRoot.left);
         printPostorder(theRoot.right);
         System.out.print(" "+ theRoot.data);
      }
   }
   
   public int sum() {
      return sum(this.root);
   }
   
   private int sum(IntTreeNode theRoot) {
      if (theRoot == null) {
      return 0;
      }
      else {
         return sum(theRoot.left) + theRoot.data + sum(theRoot.right);
      }
   }
}