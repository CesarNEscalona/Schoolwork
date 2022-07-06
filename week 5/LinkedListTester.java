public class LinkedListTester {

   public static void main(String[] args) {
      System.out.println("Welcome to list tester");
      
      LinkedIntList list = new LinkedIntList();
      
      list.add(10);  // 0
      list.add(42);  // 1
      list.add(15);  // 2
      list.add(30);  // 3
      list.add(22);  // 4
      
      System.out.println(list);
      
      System.out.println("This list has " + list.size() + " items.");
      
      System.out.println("Item 2 has the value " + list.get(2));
      // above line should print out 15
      
      // now, the list looks like [10, 42, 15, 30, 22]
      // add a value in the middle
      list.add(2, 99);
      // the list should now look like [10, 42, 99, 15, 30, 22]
      System.out.println(list);
      
      list.add(0, 555);
      // the list should now look like [555, 10, 42, 99, 15, 30, 22]
      System.out.println(list);
      
      list.remove(2);
      // the list should now look like [555, 10, 99, 15, 30, 22]
      System.out.println(list);
      
   }
   
}
   