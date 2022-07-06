/*
   Cesar Escalona
   It-220
   04/24/2020
   This program will create a Hippo and will run on the CritterMain java
*/

import java.awt.*;
import java.util.Random;

public class Hippo extends Critter {
   private int moveNumber;
   private int hunger;
   private boolean hasEaten;
   private Random rng;   // random number generator
   private Direction currentDirection;

   // Parameterized Constructor
   public Hippo(int hunger) {
      this.hunger = hunger;
      moveNumber = 1;
      rng = new Random();
   }
   
   // Color should be White unless still hungry
   @Override
   public Color getColor() {
      if (hunger == 0)
      {
         return Color.WHITE;
      }
      else
      {
         return Color.GRAY;
      }
   }
   
   // Should eat the given amount of times, once it reaches
   // 0, it will not eat anymore
   @Override
   public boolean eat() {
      if(this.hunger > 0)
      {
         hunger--;
         hasEaten = true;
         return true;
      }
      else if(hunger == 0)
      {
         hasEaten = false;
         return false;
      }
      else
      {
         return false;
      }
   }
   
   // Should scratch if hippo's still hungry, otherwise pounce
   @Override
   public Attack fight(String opponent) {
      if (eat())
      {
         return Attack.SCRATCH;
      }
      else
      {
         return Attack.POUNCE;
      }
   }
   
   // Should return the amount of food it should eat,
   // once full it should show 0 and hunger should be false
   @Override
   public String toString() {
      return "" + hunger;
   }
   
   // Randomly move the Hippo
   @Override
   public Direction getMove() {
     
      if (moveNumber ==  1 ) {
         int num = rng.nextInt(4);
         
         if(num == 0) {
            currentDirection = Direction.NORTH;
         }
         else if(num == 1) {
            currentDirection = Direction.EAST;
         }
         else if(num == 2) {
            currentDirection = Direction.SOUTH;
         }
         else {
            currentDirection = Direction.WEST;
         }
      }
          
      moveNumber++;
      if(moveNumber > 5) {
         moveNumber = 1;
      }
      return currentDirection;
      
   } // end of getMove
   
} // end of Class