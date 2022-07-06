/*
     Cesar Escalona
     It-219
     Final Project - Butterflies
     This program will create a butterfly using GObjects that will be used with 
     file ButterflyTester
*/

import acm.graphics.*; 
import java.awt.Color;

public class Butterfly extends GCompound
{
   private double speed;
   
   // Parameterized constructor for butterfly and pass in speed
   public Butterfly(double speed)
   {
      this.speed = speed;
      
      // butterfly body
      GOval body = new GOval(25,25,10,40);
      body.setFillColor(Color.BLACK);
      body.setFilled(true);
      
      // butterfly wing right top side
      GOval wingrt = new GOval(30,25,23,23);
      wingrt.setFillColor(Color.YELLOW);
      wingrt.setFilled(true);
      
      // butterfly wing right bottom side
      GOval wingrb = new GOval(27,45,19,19);
      wingrb.setFillColor(Color.YELLOW);
      wingrb.setFilled(true);
      
      // butterfly wing left top side
      GOval winglt = new GOval(5,25,23,23);
      winglt.setFillColor(Color.YELLOW);
      winglt.setFilled(true);
      
      // butterfly wing left bottom side
      GOval winglb = new GOval(13,45,19,19);
      winglb.setFillColor(Color.YELLOW);
      winglb.setFilled(true);
      
      // glud all created parts together to create butterfly image
      add (wingrb);
      add (winglb);
      add (wingrt);
      add (winglt);
      add (body);
   }
   
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