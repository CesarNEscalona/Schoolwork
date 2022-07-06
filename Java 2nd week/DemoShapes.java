import acm.program.*;
import acm.graphics.*;  //GObjects
import java.awt.Color;

public class DemoShapes extends GraphicsProgram
{
   //init() is called for us once BEFORE run() is called
   public void init()
   {
     //sets width and height of window in pixels
     setSize(800, 600);
     setBackground(Color.CYAN);
   
   
   }
   //add GObjects to windwow
   //run is called for us
   public void run()
   {
      //Calling demoLine
      demoLine();
      //Calling demoCircle
      demoCircle();
      
   
   
   }
   //this method will place a circle in the window
   //window - defining this method
   public void demoCircle()
   {
     //upper left hand corner of the bounding
     GOval circle = new GOval(200, 100, 50, 50);
     circle.setFilled(true);
     circle.setColor(Color.YELLOW);
     add(circle); //very important to add to window    
       while(true)
       {
       //change in X and change in Y
       circle.move(10, 10);
       pause(200);//pause at 200 milliseconds
       }
   
   }
   public void demoLine()
   {
     GLine line = new GLine(0,300,800,300);
     add (line);
   
   
   }
   public static void main(String[] args)
   {
      DemoShapes test = new DemoShapes();
      //launch window
      test.start();


   }


}