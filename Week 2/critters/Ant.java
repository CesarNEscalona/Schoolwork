/*
   Cesar Escalona
   It-220
   04/24/2020
   This program will create an Ant and will run on the CritterMain java
*/

import java.awt.*;

public class Ant extends Critter {
	
   private int moveNumber;
   private boolean walkSouth;
   
   // Parameterized Ant constructor
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
   }
   
   // Every time the Ant runs into another animal
   // it will always fight and scratch
   @Override
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }

	// Changes the color of the symbol to red
   @Override
   public Color getColor() {
      return Color.RED;
   }

	// Changes the symbol
   @Override
   public String toString() {
      return "%";
   }
   
   // Everytime it encounters food, it eats
   @Override
   public boolean eat() {
      return true;
   }
   
   // Moving direction
   @Override
   public Direction getMove()  {
      if(walkSouth){
         if(moveNumber == 0)
         {
            moveNumber++;
            return Direction.SOUTH;
         }
         else if(moveNumber == 1)
         {
            moveNumber = 0;
            return Direction.EAST;
         }
         else
         {
            moveNumber++;
            return Direction.SOUTH;
         }
      } // end of if
      else {
         if(moveNumber == 0)
         {
            moveNumber++;
            return Direction.NORTH;
         }
         else if(moveNumber == 1)
         {
            moveNumber = 0;
            return Direction.EAST;
         }
         else
         {
            moveNumber++;
            return Direction.NORTH;
         }
      } // end of else
   
   } // end of get move
   
} // end of class