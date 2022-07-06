/*
   This program will print out ascii characters and escape sequences to the console


*/
public class Ascii
{

    public static void main(String[] args)
    {
    //print out "He said , "Java is easy?""
    System.out.print("He said, \"Java is easy?\"");
    //print "Absolutely"
    System.out.print("\n Absolutely \n");
     
     //call the asciiBox method INVOKE the method
     asciiBox();
     
     //use println to print out "That was easy"
     //use println to print out "Absolutely"
     System.out.println("That was easy!");
     
     System.out.println("Absolutely");
     
    }//end of main method
    
    /** Javadoc comment
    *   This method will draw a box with ascii characters
    *
    */
    public static void asciiBox( )
    {
       System.out.println(" \\\\\\\\\\");
       System.out.println("  \\\\\\\\\\");
       System.out.println("<<|---|-----\\");
       System.out.println("<<|_ _|");
       System.out.println("<<|   |");
       System.out.println("<<|---|-----/");
       System.out.println("  /////");
       System.out.println(" /////");
              
    } //end of the asciiBox method


} // end of class

/*
This is the output

 ----jGRASP exec: java Ascii
 He said, "Java is easy?"
  Absolutely 
  \\\\\
   \\\\\
 <<|---|-----\
 <<|_ _|
 <<|   |
 <<|---|-----/
   /////
  /////
 That was easy!
 Absolutely
 
  ----jGRASP: operation complete.
 
 */
 