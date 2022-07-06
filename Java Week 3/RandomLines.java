/*
  This program will generate randomly colored GLine's in
  random locations
 */
 
 import acm.program.*;
 import acm.graphics.*;
 import java.awt.Color;
 import java.util.Random;
 
 public class RandomLines extends GraphicsProgram
 {
     // constructor method - java puts this in
     public RandomLines()
     {
        super();  // calls the constructor in
                  // GraphicsProgram
     
     }
     public void run()
     {
         final int MAX_COLOR = 256;
         // Create a Random Number Generator
         Random gen =new Random();
         
         // generate random point location (x1,y1)
         System.out.println(this.getWidth());
         System.out.println(this.getHeight());
         
         while (true)
         {
            int x1 = gen.nextInt(this.getWidth());
            int y1 = gen.nextInt(this.getHeight());
         
            // generate random point location (x2,y2)
            int x2 = gen.nextInt(this.getWidth());
            int y2 = gen.nextInt(this.getHeight());
         
            int red = gen.nextInt(MAX_COLOR);
            int green = gen.nextInt(MAX_COLOR);
            int blue = gen.nextInt(MAX_COLOR);
         
            // Create a Color object
            Color newColor = new Color(red,green,blue);
            // Create a GLine object
            GLine line = new GLine(x1,y1,x2,y2);
            line.setColor(newColor);
            add(line); // Very Important Part
         }

     }
 
     public static void main(String[] args)
     {
         // construct a RandomLines obj
         RandomLines lines = new RandomLines();
         lines.start();// displays window
     
     
     }
 
  
 }