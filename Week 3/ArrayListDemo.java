
import java.util.*;

public class ArrayListDemo {

   public static void main(String[] args) {
      System.out.println("Welcome to the ArrayList Demo!");
      
      // ----- Traditional Java array - core language ----------
      
      // construction
      String[] artistArray = new String[5];
      
      // send to method
      doArrayStuff(artistArray);
      
      // print to System.out (console)
      System.out.println(artistArray);
      System.out.println(Arrays.toString(artistArray));
      
      // access individual items
      artistArray[4] = "Snail's House";
      System.out.println(artistArray[4]);
      
      // get and print number of items
      System.out.println("There are " + artistArray.length + " items");
      
      
      // ----- ArrayList class - part of java.util -------------

      // construction
      ArrayList<String> artistList = new ArrayList<>();
      
      // send to method
      doArrayListStuff(artistList);
      
      // print to System.out (console)
      System.out.println(artistList);
      
      // access individual items
      artistList.set(4, "ColdPlay");
      System.out.println(artistList.get(4));
      
      // get and print number of items
      System.out.println("There are " + artistList.size() + " items");
      
   } // end method main
   
   
   public static void doArrayStuff(String[] array) {
      array[0] = "jcole";
      array[1] = "post malone";
      array[2] = "Mili";
      array[3] = "pinkfloyd";
      array[4] = "Snail's house";
   }
   
   public static void doArrayListStuff(ArrayList<String> list) {
      // add() will add to the back of the arraylist
      list.add("eddie vetter");
      list.add("NF");
      list.add("Flux Pavilion");
      list.add("Daft Punk");
      list.add("Coldplay");
   }
   

} // end class ArrayListDemo