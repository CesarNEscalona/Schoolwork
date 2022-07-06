import acm.graphics.*; // GOval GRect
import java.awt.Color;

public class Car extends GCompound
{
    private double speed;
    
    // parameterized constructor for Car pass in speed
    public Car(double speed)
    {
        // initialize speed
        this.speed = speed;
        
        //create a top for car GOval
        GOval top = new GOval(40,25,40,35);
        top.setFillColor(Color.BLACK);
        top.setFilled(true);
        
        // create a car body
        GRect body = new GRect(25,35,70,30);
        body.setFillColor(Color.BLUE);
        body.setFilled(true);
        
        // create wheel1
        GOval wheel1 = new GOval(30,50,20,20);
        wheel1.setFillColor(Color.BLACK);
        wheel1.setFilled(true);
        
        // create wheel2
        GOval wheel2 = new GOval(70,50,20,20);
        wheel2.setFillColor(Color.BLACK);
        wheel2.setFilled(true);
        
        // glue car parts together
        add(top);
        add(body);
        add(wheel1);
        add(wheel2);
    
    }// end of constructor

   //getter for speed
   public double getSpeed()
   {
      return this.speed;
   }
   
   // setter for speed
   public void setSpeed(double speed)
   {
      this.speed = speed;
   }
}// end of class