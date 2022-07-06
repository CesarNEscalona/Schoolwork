// Name: Cesar Escalona
// IT 219
// Core Topics: Creating a java program 
// with static methods
//
// This program will call a series 
// of static methods to display output to the console
// window
public class StaticMethods {

   // java always looks for the main method to begin execution
   public static void main(String[] args) {
      // add code here to print out the rocketship
      // shown below
      drawCone();
      drawBox();
      drawReverseCone();
      
      
      // Hint call drawBox()  call drawCone()
      //      call drawReverseCone()
   } // end method

   // this method draws a single ascii cone
   public static void drawCone() {
   System.out.println("   /\\");
   System.out.println("  /--\\");
   System.out.println(" /----\\");
   System.out.println("/------\\");
   
   
   }// end method

   // this method draws a single ascii box
   public static void drawBox() {
   System.out.println("+------+");
   System.out.println("|      |");
   System.out.println("|      |");
   System.out.println("+------+");
   System.out.println("+------+");
   System.out.println("|      |");
   System.out.println("|      |");
   System.out.println("+------+");
   
   
   } // end method

   

   // this method draws an upside down cone
   public static void drawReverseCone() {
   System.out.println("\\------/");
   System.out.println(" \\----/");
   System.out.println("  \\--/");
   System.out.println("   \\/");
   
   
   } // end method
   
} // end class
/*
 ----jGRASP exec: java StaticMethods
    /\
   /--\
  /----\
 /------\
 +------+
 |      |
 |      |
 +------+
 +------+
 |      |
 |      |
 +------+
 \------/
  \----/
   \--/
    \/
 
  ----jGRASP: operation complete.
*/
/*
 ----jGRASP exec: java StaticMethods
    /\
   /--\
  /----\
 /------\
 +------+
 |      |
 |      |
 +------+
 +------+
 |      |
 |      |
 +------+
 \------/
  \----/
   \--/
    \/
 
  ----jGRASP: operation complete.
 

*/