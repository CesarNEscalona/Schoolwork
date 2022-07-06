/*
   Cesar Escalona
   IT-219
   02/04/2020
   This program will display a window with a truck traveling on a road.
   The truck will respawn at the start of the road after it drives from the window.
*/

import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.*;     // * adds all classes
import acm.program.GraphicsProgram;

public class Highway extends GraphicsProgram
{
   //declare the object as a field so it can be seen throughout the class run()  keypressed()
   private Vehicle truck; // null
	private GImage frog;   // null
   
	public void init()
   {
		// set background color
		this.setBackground(Color.GREEN);

		// set window size
		this.setSize(800, 600);
      
      // tell the GraphicsProgram to listen for key events
      this.addKeyListeners();
	}
   // this method ges called for us and is passed info on the keypressed
   public void keyPressed(KeyEvent e)
   {
      final int SPEED = 5;
      switch(e.getKeyCode())
      {
         
         case KeyEvent.VK_UP:
            frog.move(0, -SPEED);
            break;
            
         case KeyEvent.VK_LEFT:
            frog.move(-SPEED,0);
            break;
            
         case KeyEvent.VK_RIGHT:
            frog.move(SPEED,0);
            break;
            
         case KeyEvent.VK_DOWN:
            frog.move(0,SPEED);
            break;
            
            
      }  // end of switch
   }
	public void drawRoad()
   {
		// draw a Road
		GRect road = new GRect(0, this.getHeight() / 3, this.getWidth(), this.getHeight() / 4);
		road.setColor(Color.GRAY);
		road.setFilled(true);
		this.add(road);
	}

	public void run()
   {
		// draw the road before vehicles so you don't cover them up
		drawRoad();
      
      frog = new GImage("frogsmal.png");
      add(frog,this.getWidth() / 2,this.getHeight() - frog.getHeight());  // adding the x,y of the frog
      truck = new Vehicle(8.5);
      // add truck
      add(truck, 0, 175);
     
      while(true)
      {
         truck.move(truck.getSpeed() ,0);
         pause(200);
         
         // if the frog runs into the car
         if(frog.getBounds().intersects(truck.getBounds()))
         {
            break;
         }
         
         // if truck exits right
         if(truck.getX() > this.getWidth())
         {
            // set the truck back to the left side
            truck.setLocation(-130, truck.getY());
         }
      }  // end of while
       this.remove(frog);
       System.out.println("Game Over");
       
   }
   
	public static void main(String[] args)
   {
		new Highway().start();
	}
}