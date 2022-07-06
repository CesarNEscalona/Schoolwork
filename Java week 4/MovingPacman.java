import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.Random;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;


public class MovingPacman extends GraphicsProgram
{
      // constants for window size
      private static final int APPLICATION_WIDTH = 800;
      private static final int APPLICATION_HEIGHT = 600;
      
      // create a class variable(static) that has scope throughout
      // the class
      private static double speed; // pacmac moves this fast
                                   // in pixels
      // called before run
      public void init()
      {
         this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
         this.setBackground(Color.CYAN);
         System.out.println(speed); 
         
         addKeyListeners();// registering with the JVM
                           // we are interesting in keyPresses
  
      
      }
           
      public void run() 
      {
         // Prompt the user for the speed
         speed = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter PacMan's speed"));
         System.out.println(speed);
         
         // Create a PacMan shape
         // 
         GArc pacMan = new GArc(50,50,50,50,45,270);
         pacMan.setFilled(true);
         pacMan.setFillColor(Color.RED);
         add(pacMan);
         
         while(true)
         {
            //move pacman horizontally by speed entered
            pacMan.move(speed,0);
            pause(200);
            System.out.println(pacMan.getX());
            if(pacMan.getX() > this.getWidth())
            {
                // move PacMan back to left
                pacMan.setLocation(0,pacMan.getY());
               
            
            }
         
         }
         
                   
      
      
      }
      
      // automatically called with a key is pressed on the keyboard
      // IF you addKeyListeners() in the init() or run() method
      // remember to give focus to the window before pressing keys
      public void keyPressed(KeyEvent e)
      {
        // automatically call the toString()
        //System.out.println(e);
        speed += 10;
      }
           
      
      public static void main(String[] args)
      {
      
          MovingPacman test = new MovingPacman();
          test.start();
      
      }




}