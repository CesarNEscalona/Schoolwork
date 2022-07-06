public class LinkedNodes9 {
   public static void main(String[] args) {
   
      ListNode list = new ListNode(1, new ListNode(2, null));
      
      list.next.next = new ListNode(3, null);
      System.out.println(list);
   }
}