public class LinkedNodes10 {
   public static void main(String[] args) {
   
      ListNode list = new ListNode(1, new ListNode(2, null));
      
      list = new ListNode(3, list);
      
      System.out.println(list);
      
   
   }
}