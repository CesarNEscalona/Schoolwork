/*
     Cesar Escalona
     It-219
     Final Project
     This program will create a game of butterflies,
     You will be able to catch the butterflies with the net and once you
     catch 5 butterflies, the game is over
*/

import java.awt.Color; 
import java.awt.event.KeyEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class ButterflyTester extends GraphicsProgram
{
   
   // declare an array of butterflies
   private Butterfly[] butterflies = { new Butterfly(10), new Butterfly(30), new Butterfly(25), new Butterfly(20), new Butterfly(5), };
      
   // declare Net image
   private GImage net; 
      
   // declare the background
    public void init()
   {
      setBackground(Color.CYAN);
      setSize(1200, 800);
      this.addKeyListeners();
   } // end of method
   
   // creating a method for user keypresses
   public void keyPressed(KeyEvent k)
   {
      final int SPEED = 10;
      
       switch(k.getKeyCode())
       {
           case KeyEvent.VK_UP:
               net.move(0, -SPEED);
               break;
               
           case KeyEvent.VK_DOWN:
               net.move(0, SPEED);
               break; 
       } // end of switch
   
   } // end of method
   
   // creating a method that will run the program
   public void run()
   {
      net = new GImage("net.png");
      add(net,1125, 0);
      int y = 0; // Start location
      int x = 200;
      for (Butterfly c : butterflies)
      {
         add(c,x,y);
         y += 150;
      }
      
      // creating a loop that will keep the butterflies running until you reach 5
      boolean gameOver = false;
      int count = 0;
      while(gameOver == false)
      {
         for (int i=0; i<butterflies.length; i++)
         {
            butterflies[i].move(butterflies[i].getSpeed(),0);
             // if butterfly runs into net
            if(net.getBounds().intersects(butterflies[i].getBounds()))
            {
               count++;
               butterflies[i].setLocation(-10,butterflies[i].getY());
               System.out.println("Nice catch!");
               if(count == 5)
               {
                  System.out.println("\nWow you caught " + count +" butterflies!");
                  gameOver = true;
               }
            }
            
            // if butterfly exits screen
            if(butterflies[i].getX() > this.getWidth())
            {
               //set the butterfly back
               butterflies[i].setLocation(-10,butterflies[i].getY());
            }
          } // end of for
          pause(150);
      }// end of while
      
      System.out.println("Game Over");
      this.remove(net);
	}  // end of run
   
   // This is the main method
   public static void main(String[] args) 
   {
		new ButterflyTester().start();
	} // end of main method
} // end of class