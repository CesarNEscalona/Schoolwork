//put in te imports needed to draw in a window with Gpen
import acm.program.*;  //window


/*
        Name:
        Date:
        


*/
import acm.graphics.GPen;  //import GPen class
import java.awt.Color;

public class Square extends GraphicsProgram
   {
     public void run()
     {
     GPen pen = new GPen();
     add(pen); //very important
     pen.setLocation(200, 150);
     pen.startFilledRegion();  //setting filled region
     
     pen.setColor (Color.RED);
     
     //draw box
     pen.drawLine (50, 0);  //horiontal line
     pen.drawLine (0, 50);  //vertical line
     pen.drawLine (-50, 0);
     pen.drawLine (0, -50);
     pen.endFilledRegion();
     
     
     pen.setSpeed (0.1);
     pen.setLocation (300, 300);
     pen.drawLine (250, 250);
     
     
    
     }
    public static void main(String[] args)
    {
      //construct a Square object from this class
      Square obj = new Square();
      obj.start();
    
    
    }
     
   
   } //end of class
   
   /*
   
   NOTES 
   
    1)Defining the method
         pubic static void main(String[] args)
         {
         
         }
         
    2) We cannot call the main method directly as a programmer
    
    Call 
    
    
    */