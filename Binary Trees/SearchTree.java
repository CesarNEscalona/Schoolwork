/*
   Cesar Escalona
   it-220
   06/13/2020
*/

public class SearchTree<E extends Comparable<E>> {
   
   // field(s)
   private SearchTreeNode<E> overallRoot;   // default is null
   
   // methods
   public SearchTree() {
      // default was null but writing to be sure
      overallRoot = null;
   }
   // public helper method
   public void add(E value) {
      overallRoot = add(overallRoot, value);
   }
   
   private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
      if (root == null) {
         root = new SearchTreeNode<>(value);
      }
      else if (value.compareTo(root.data) <= 0) {
         root.left = add(root.left, value);
      }
      else {
         root.right = add(root.right, value);
      }
      return root;
   }
   
   // public helper method
   public boolean contains(E value) {
      return contains(overallRoot, value);
   }
   
   // private recursive method - this one does all the work
   private boolean contains(SearchTreeNode<E> root, E value) {
      if (root == null) {
         return false;
      }
      else {
         int compare = ((Comparable<E>)value).compareTo(root.data);
         if(compare == 0) {
            return true;
         }
         else if(compare < 0) {
            return contains(root.left, value);
         }
         else {
            return contains(root.right, value);
         }
      }
   }
   
   //public helper method
   public void printInorder() {
      printInorder(overallRoot);
      System.out.println();
   }
   
   // private recursive method that does the work
   private void printInorder(SearchTreeNode<E> root) {
      if(root != null) {
         printInorder(root.left);
         System.out.println(" "+ root.data);
         printInorder(root.right);
      }
   }
      
}