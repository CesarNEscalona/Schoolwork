import java.util.Scanner; // allows us to create Scanner objects

public class ScannerReview 
{

   // starting point for our console program
   // we put other methods in here to call 
   //(we do not define methods in main)
	public static void main(String[] args)
   {
       // construct a Scanner object from the Scanner class to connect
       // to the keyboard
       //pattern
       //class_name     object_name    =   new   class_name(parameters);
       Scanner keyboard = new Scanner(System.in);
     
       //Prompt the user to enter their age as an integer
       System.out.print("Enter your age: ");
       
       // TODO: Read in the age using the .nextInt() method on the keyboard object
       int age = keyboard.nextInt();
       
       // Prompt the user to enter their height in inches as a decimal
       System.out.print("Enter your height in inches:");
       
       // TODO: Read in the height using the .nextDouble() method on the keyboard object
       double height = keyboard.nextDouble();
       
       // fix remove the new line leftover in buffer
        keyboard.nextLine();   
       
       
       // Prompt the user to enter their first name
       System.out.print("Enter your first name:");
       
       // TODO: Read in the first name using .next() method
      //String firstName = keyboard.next();
      
          
      // TODO: Now try reading in the first name using .nextLine() method rather than the .next(), Remember to COMMENT out the line above   
      String firstName = keyboard.nextLine();
      
      // Uncomment when finished to test your code
         System.out.println("Welcome, " + firstName + " you are " + height + " inches tall and " + age + " years old.");
      
        	
   } // end of main method

} // end of class
