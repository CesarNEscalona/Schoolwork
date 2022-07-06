/*
   Names: Lennox Anderson & Ian Schroeder
   Date: 30Jan20
   
   This program will display a sandwich order
   Then the sandwich order changes and the order is displayed again
*/

public class TestSandwich 
{

	public static void main(String[] args) 
  {
		// construct a Sandwich object using parameters
		Sandwich sand1 = new Sandwich("Rye","Tuna",5.99);
      System.out.println(sand1);
      
		// using the Sandwich object to 
		// call get the methods      
		System.out.println(sand1.getBread());
      System.out.println(sand1.getFilling());
      System.out.println(sand1.getPrice());
      
		// calling the set methods
      // to modify the sandwich      
      sand1.setBread("Wheat");
      sand1.setFilling("Turkey");
      sand1.setPrice(6.50);
		
		// displaying the new sandwich order to
      // verify changes were made correctly      
      System.out.println(sand1);
		

	}// end of main method

}// end of class

/*
     ----jGRASP exec: java TestSandwich
 Your Tuna on Rye will be 5.99.
 Rye
 Tuna
 5.99
 Your Turkey on Wheat will be 6.5.
 
  ----jGRASP: operation complete.
*/