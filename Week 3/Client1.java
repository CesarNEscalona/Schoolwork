

public class Client1 {
   public static void main(String[] args) {
   
      System.out.println("Hello, Client 1");
      
      // Construct two ArrayLists, named list1 and list2
      ArrayIntList list1 = new ArrayIntList(200);
      ArrayIntList list2 = new ArrayIntList(10);

      // add 1, 82, 97, to the back of list1
      list1.add(1);
      list1.add(82);
      list1.add(97);
      
      // add 7, -8 to the back of list2
      list2.add(7);
      list2.add(-8);
      
      // add a 5 to the beginning of both lists
      list1.add(0, 5);     // add the value 5 at position/index 0
      list2.add(0, 5);     // go to index 0, slide everything over, and put a 5 there  
      
      // print out lists
      System.out.println("list 1 is " + list1);
      System.out.println("list 2 is " + list2);
      
      // get the sizes of the lists
      System.out.println("list 1 has " + list1.size() + " items");
      System.out.println("list 2 has " + list2.size() + " items");
      
      // get a single item from the list
      System.out.println(list1.get(2));
      
      int theIndex = list1.indexOf(82);   // should be 2   
      System.out.println(theIndex);
      list1.remove(theIndex);
      System.out.println(list1);
   }
}