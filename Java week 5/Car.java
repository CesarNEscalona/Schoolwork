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
        
        // create a top for car GOval
        GOval top = new GOval(60,30,60,50);
        top.setFillColor(Color.BLACK);
        top.setFilled(true);
        
        // create a car body
        GRect body = new GRect(30,50,120,40);
        body.setFillColor(Color.RED);
        body.setFilled(true);
        
        // create wheel1
        GOval wheel1 = new GOval(40,80,20,20);
        wheel1.setFillColor(Color.BLACK);
        wheel1.setFilled(true);
        
        // create wheel2
        GOval wheel2 = new GOval(120,80,20,20);
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
