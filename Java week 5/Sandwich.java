/*
   Names: Lennox Anderson & Ian Schroeder
   Date: 30Jan20
   
   This is a custom class created for the TestSandwich program.
*/

public class Sandwich 
{
   // instance fields
	private String filling;
	private String bread;
   private double price;
   	
	// parameterized constructor 
	public Sandwich(String bread, String filling, double price)
   {
       this.filling = filling;
       this.bread = bread;
       this.price = price;   
   }// end of constructor
		
	// getters
	public String getFilling()
   {
       return this.filling;
   }

   public String getBread()
   {
       return this.bread;
   }
   
   public double getPrice()
   {
       return this.price;
   }
	  
	
	// setters
   public void setFilling(String f)
   {
       this.filling = f;
   }

   public void setBread(String b)
   {
       this.bread = b;
   }

   public void setPrice(double p)
   {
       this.price = p;
   }   
	
	// toString for display
   public String toString()
   {
       return "Your " + filling + " on " + bread + " will be " + price + ".";
   
   }
   
}// end of class
