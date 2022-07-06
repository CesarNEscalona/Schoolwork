import java.util.Random;   // importing the random number generator

public class Die
{
   // instance fields
   private int numSides;
   
   // default constructor
   public Die()
   {
      numSides = 1;
   }
   
   // parameterzed constructor
   public Die(int sides)
   {
      numSides = sides;
   }
   
   // method
   public int roll()
   {
      Random rand = new Random();
      
   }
   
   // getter
   public int getNumSides()
   {
      return numSides;
   }
   
   //setter
   public void setNumSides(int numSides)
   {
      this.numSides = numSides;
   }
   
   // getter
   public int getValue()
   {
      roll();
   }
   
   @Override
   // public to string
   public String toString()
   {
      return "Die has " +numSides+ " sides.\nYou Rolled a " +value ;
   }
}