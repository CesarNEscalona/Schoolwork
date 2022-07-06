/*
    Cesar Escalona
    IT-219
    HW#2b Random Shapes
    This program will generate random colored shapes based on the number the user inputs
*/
 import acm.program.*;
 import acm.graphics.*;
 import java.awt.Color;
 import java.util.Random;
 import javax.swing.*;
 import java.util.Scanner;
 
 public class RandomShapes extends GraphicsProgram
 {
     // Window size
     private static final int APPLICATION_WIDTH = 800;
     private static final int APPLICATION_HEIGHT = 600;
     
     
     public void init()
     {
         this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
         this.setBackground(Color.CYAN);   
     }
     
     public void run()
     {
          // create a Random Number Generator
          Random gen = new Random();
          
          //create ramdom colors
          int red = gen.nextInt(256);
          int green = gen.nextInt(256);
          int blue = gen.nextInt(256);
       
          // Create a Color object
          Color newColor = new Color(red, green, blue);
          
          // Prompt the user for a number
          String num1 = JOptionPane.showInputDialog(null, "How many shapes should I draw(Choose 1 or 2)?");
          int number = Integer.parseInt(num1);
          System.out.println(number);
             
          if ( number == 1)
          {
             GRect square = new GRect(400,100,100,100);
          square.setFilled(true);
          square.setFillColor(newColor);  // random color
          add(square); 
          }
          else 
          {
          // Create a shape
          GRect square = new GRect(400,100,100,100);
          square.setFilled(true);
          square.setFillColor(newColor);  // random color
          add(square);
          
          // Create a shape
          GArc pc = new GArc(100,100,100,100,90,180);
          pc.setFilled(true);
          pc.setFillColor(newColor);  // random colors
          add(pc);  
          }
     }
     public static void main(String[] args)
     {
        
        RandomShapes test = new RandomShapes();
        test.start();
     }
 }