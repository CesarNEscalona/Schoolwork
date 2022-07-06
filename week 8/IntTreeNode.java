
public class IntTreeNode {
   // fields
   public int data;
   public IntTreeNode left;      // address of the child node to my left
   public IntTreeNode right;     // address of the child node to my right
   
   // helper constructors
   public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   public IntTreeNode(int data) {
      this(data, null, null);
   }
}