
// This class (or data structure / data type) is similar to what
// the ArrayIntList does, except it uses linked nodes, instead of
// an plain-old Java array inside.

public class LinkedIntList {

   // fields
   private ListNode front;   // holds the address of the first node in line
   
   
   // methods
   public LinkedIntList() {
      // when someone makes a new LinkedIntList
      // there are zero / no ListNodes in the list
      // so we will set the front to null to indicate that
      front = null;
   }
   
   // adds a new element to the back of the list
   public void add(int value) {
      if (front == null) {
         // if the list is empty (has no nodes)
         front = new ListNode(value, null);
      }
      else {
         // we know if we get here, there is at least one node
         // in the linked list
      
         // so walk/traverse from the front to the back of the list
         // and then put in a new node at the end of the list
         ListNode current = front;
         
         while (current.next != null) {
            current = current.next;
         }
         
         current.next = new ListNode(value, null);
      }
   }
   
   // add a new node with data = value, before the specified index
   public void add(int index, int value) {
      if (index == 0) {
         // if someone is adding before index 0 (front of list)
         // we actually need to change the front field (instance variable)
         
         front = new ListNode(value, front);
      }
      else {
         ListNode current = front;
         
         for (int i = 0; i < index - 1; i++) {
            current = current.next;
         }
         
         // or you can call a helper method that we wrote, instead of above
         // ListNode current = nodeBefore(index);
         
         // current has the address of (is pointing to) the node before index
         current.next = new ListNode(value, current.next);
      }   
   }
   // remove the value at the given index
   public void remove(int index) {
      if (index == 0) {
         // if I am removing the node at the front
         front = front.next;
      }
      else {
         // I am removing somewhere in the middle
         ListNode current = front;
         
         for (int i = 0; i < index - 1; i++) {
            current = current.next;
         }
         
         // or you can call a helper method that we wrote, instead of above
         // ListNode current = nodeBefore(index);
         // or
         // ListNode current = nodeAt(index - 1);
         
         // when I get here, outside the loop, current is at node before index
         current.next = current.next.next;
      }
   }
   
   public int size() {
      // there is no size field in our linked list
      // so we have to manually count up the nodes by
      // traversing / visiting / walking from the front to the back
      
      int count = 0;
      
      ListNode current = front;
      while (current != null) {
         count++;
         current = current.next;
      }
      
      return count;   
   }
   
   // When someone gives me an "index" get will return the data (value)
   // at that position/index.
   public int get(int index) {
      // doing it manually
      
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      
      return current.data;
      
      
      // calling the helper method instead
      // return nodeAt(index);
   }
   
   // change the .data at the node at index, replace it with value
   public void set(int index, int value) {
   
      ListNode current = front;
      
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
 
      // once I am here, outside the loop, current is at the node of interest
      current.data = value;
   }
   
   @Override
   public String toString() {
      if (front == null) {
         return "[]";
      }
      else {
         String result = "[";
         
         // join in the first value
         result += front.data;
         
         // join in the remaining values, with commas in between
         ListNode current = front.next;
         
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
         }
         
         result += "]";
         return result;
      }
   }
   
   // get the address of a node at index
   private ListNode nodeAt(int index) {
      ListNode current = front;
      
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      
      return current;
   }
      
   
   // get the address of the node before the one at index
   private ListNode nodeBefore(int index) {
      ListNode current = front;
         
      for (int i = 0; i < index - 1; i++) {
         current = current.next;
      }
      
      // when I get here, current is at the node before index
      return current;
   }

}