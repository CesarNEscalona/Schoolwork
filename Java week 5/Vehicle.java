/*
   Cesar Escalona
   IT-219
   02/04/2020
   This program creates a truck that will be used in Highway.Java
*/
import acm.graphics.*; // GOval GRect
import java.awt.Color;


public class Vehicle extends GCompound
{
   // instant field
   private double speed;
   
   // parameterized constructor for Truck
   public Vehicle(double speed)
   {
      // initialize speed
      this.speed = speed;
      
      // create the Truck top
      GRect top = new GRect(80, 30, 40, 20);
      top.setFillColor(Color.BLACK);
      top.setFilled(true);
      
      // create a Truck body
      GRect body = new GRect(30,50,120,40);
      body.setFillColor(Color.WHITE);
      body.setFilled(true);
        
      // create wheel1
      GOval wheel1 = new GOval(40,80,30,30);
      wheel1.setFillColor(Color.BLACK);
      wheel1.setFilled(true);
        
      // create wheel2
      GOval wheel2 = new GOval(110,80,30,30);
      wheel2.setFillColor(Color.BLACK);
      wheel2.setFilled(true);
      
      // glue car parts together
      add(top);
      add(body);
      add(wheel1); 
      add(wheel2);
   
   }  // end of constructor
   
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
} // end of class