/*
   Cesar Escalona
   It-220
   04/24/2020
   This program will create a Husky and will run on the CritterMain java
*/

import java.awt.*;
import java.util.Random;

public class Husky extends Critter {
   private int moveNumber;
   private int moveCounter;
   private int hunger;
   private boolean hasEaten;
   private Random rng;   // random number generator
   private Direction currentDirection;
   
   public Husky(int hunger) {
      this.hunger = hunger;
      rng = new Random();
   }

    // Color should be RED unless still hungry
   @Override
   public Color getColor() {
      if (hunger == 0)
      {
         return Color.RED;
      }
      else
      {
         return Color.MAGENTA;
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
   
   @Override
    public String toString() {
      if(moveCounter == 0)
      {
         moveCounter++;
         return "\u2B12";   
      }
      else if(moveCounter == 1)
      {
         moveCounter = 0;
         return "\u2B13";   
      }
      else
      {
         moveCounter++;
         return "\u2B12";
      }
   }
   
   // Randomly move the Husky
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
      if(moveNumber > 4) {
         moveNumber = 1;
      }
      return currentDirection; 
   } // end of getMove
      
   // if Husky fights Ant, it will Roar, if it fights bird or vulture, it will Scratch
   // If it fights a hippo who hasEaten it will Scratch otherwise it will Roar.
   @Override
   public Attack fight(String opponent) {
      if(opponent.equals("%")) {
         return Attack.ROAR;
      }
      else if(opponent.equals("^")) {
         return Attack.SCRATCH;
      }
      else if(opponent.equals(">")) {
         return Attack.SCRATCH;
      }
      else if(opponent.equals("V")) {
         return Attack.SCRATCH;
      }
      else if(opponent.equals("<")) {
         return Attack.SCRATCH;
      }
      else if(opponent.equals("0")) {
         return Attack.SCRATCH;
      }
      else {
         return Attack.ROAR;
      }
      
   } // end of fight
   
} // end of class