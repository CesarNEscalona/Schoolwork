/*
   Cesar Escalona
   It-220
   04/24/2020
   This program will create a Butterfly and will run on the CritterMain java
*/

import java.awt.*;


public class Butterfly extends Critter {
   private int moveCounter;
   private int moveNumber;
    
   // Always eats 
   @Override
   public boolean eat() {
      return true;
   }
   
   // Always Forfeits and doesn't fight
   @Override
    public Attack fight(String opponent) {
      return Attack.FORFEIT;
   }
   
   // Butterdly Color is Yellow
   @Override
   public Color getColor() {
      return Color.YELLOW;
   }
	
   // Should zig zag North, West, North, East
   @Override
   public Direction getMove()
   {
       
      if(moveNumber == 0)
      {
         moveNumber++;
         return Direction.NORTH;
      }
      else if(moveNumber == 1)
      {
         moveNumber++;
         return Direction.WEST;
      }
      else if(moveNumber == 2)
      {
         moveNumber++;
         return Direction.NORTH;
      }
      else if(moveNumber == 3)
      {
         moveNumber = 0;
         return Direction.EAST;
      }
      else
      {
         moveNumber++;
         return Direction.NORTH;
      }
       
   }
   
   // Should change every move, x, -, x
   @Override
    public String toString() {
      if(moveCounter == 0)
      {
         moveCounter++;
         return "x";   
      }
      else if(moveCounter == 1)
      {
         moveCounter = 0;
         return "-";   
      }
      else
      {
         moveCounter++;
         return "x";
      }
   } // end of toString
} // end of Class