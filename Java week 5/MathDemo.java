/*
   This program will demo how to use the built-in Static Math methods, sprintf,
   determine the smallest of 3 numbers inputted bu the user.
   
   Think of Static as meaning only one and for static methods
   you do not need an object to call the methood
   all you need is the class name
*/

import javax.swing.JOptionPane;

public class MathDemo
{
   public static void main(String[] args)
   {
      // ask the user for 3 integer numbers and convert them to int at the same time
      int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter num1: "));
      int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter num2: "));
      int num3 = Integer.parseInt(JOptionPane.showInputDialog("Enter num3: "));
      
      // use built in math methods
      double sqrtRoot = Math.sqrt(num1);
      JOptionPane.showMessageDialog(null, "The Square root of "+ num1 + " = " + sqrtRoot);
      
      // Calculate the area of a circle with radius 8.9765 cm
      // and print area rounded to 2 decimal
      double radius = 8.9765;
      double area = Math.PI * Math.pow(radius,2);
      System.out.printf("Area is %.2f %s ",area, " cm^2");
      
      // take absolute value of num2
      JOptionPane.showMessageDialog(null, "The | "+ num2 + " | = " + Math.abs(num2));
      
      // cube num3 num3^3 Math.pow(num3,3)
      JOptionPane.showMessageDialog(null, num3 + " cubed is " + Math.pow(num3,3));
      
      // call the method smallestNumber and catch the return value
      // to display in JOptionPane
      int smallest = MathDemo.smallestNumber(num1, num2, num3);
      JOptionPane.showMessageDialog(null, "The smallest number is "+ smallest);
   }
   
   // This method will take 3 integer parameters and return the smallest number
   public static int smallestNumber(int n1, int n2, int n3)
   {
      // n1 = 25  n2 = -18  n3 = 4
      // if num1 <  num2 AND n1 < n3
      if (n1 < n2 && n1 < n3)
      {
         return n1;
      }  
      else if (n2 < n1 && n2 <n3)
      {
         return n1;
      }
      else
      {
         return n3;
      }
   }
}