/*
   Cesar Escalona
   It-220
   04/24/2020
   This program will create an Ant and will run on the CritterMain java
*/

import java.awt.*;

public class Bird extends Critter {
   private int moveNumber;
   
   // If opponent is an Ant it will roar, otherwise it'll pounce
   @Override
   public Attack fight(String opponent) {
      if(opponent.equals("%"))
      {
         return Attack.ROAR;
      }
      else
      {
         return Attack.POUNCE;
      }
   } // end of fight method

	// The bird is a blue color
   @Override
   public Color getColor() {
      return Color.BLUE;
   }

	// Using ^ > v < respectively to show which direction the bird is going
   @Override
   public String toString() {
      if (moveNumber == 0)
      {
         // This is how this animal should spawn in the progam >
         return ">";
      }   
      if (moveNumber == 1 || moveNumber == 2 || moveNumber == 3)
      {
         return "^";
      }
      else if (moveNumber == 4 || moveNumber == 5 || moveNumber == 6)
      {
         return ">";
      }
      else if (moveNumber == 7 || moveNumber == 8 || moveNumber == 9)
      {
         return "V";
      }
      else 
      {
         return "<";
      }
   } // end of toString
   
   // The bird never eats
   @Override
   public boolean eat() {
      return false;
   }
   
   // Moving 3 spaces north then 3 west, 3 south, 3 east then starts again
   @Override
   public Direction getMove() {      
      if (moveNumber == 1 || moveNumber == 2 || moveNumber == 3)
      {
         moveNumber++;
         return Direction.NORTH;
      }
      else if (moveNumber == 4 || moveNumber == 5 || moveNumber == 6)
      {
         moveNumber++;
         return Direction.EAST;
      }
      else if (moveNumber == 7 || moveNumber == 8 || moveNumber == 9)
      {
         moveNumber++;
         return Direction.SOUTH;
      }
      else if (moveNumber == 10 || moveNumber == 11)
      {
         moveNumber++;
         return Direction.WEST;
      }
      else
      {
         moveNumber = 1;
         return Direction.WEST;
      }
      
   } // end of getMove
   
} // end of class